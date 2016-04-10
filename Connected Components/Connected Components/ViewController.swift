import UIKit
import AVFoundation

enum Action {
	case AddNode, RemoveNode, Link
}

class ViewController: UIViewController {
	@IBOutlet weak var drawingBoard: UIView!
	@IBOutlet weak var componentsLabel: UILabel!
	
	var currentAction: Action?
	var graph = Graph()
	var currentNode: NodeView?
	var blipSound: SystemSoundID?
	var shlipSound: SystemSoundID?
	var removeSound: SystemSoundID?
	
	override func viewDidLoad() {
		super.viewDidLoad()
		currentAction = .AddNode
		if let soundURL = NSBundle.mainBundle().URLForResource("blip2", withExtension: "mp3") {
			self.blipSound = 0
			AudioServicesCreateSystemSoundID(soundURL, &blipSound!)
		}
		if let soundURL = NSBundle.mainBundle().URLForResource("shlip", withExtension: "mp3") {
			self.shlipSound = 1
			AudioServicesCreateSystemSoundID(soundURL, &shlipSound!)
		}
		if let soundURL = NSBundle.mainBundle().URLForResource("remove", withExtension: "mp3") {
			self.removeSound = 2
			AudioServicesCreateSystemSoundID(soundURL, &removeSound!)
		}
	}
	
	@IBAction func AddNodeTouched(sender: UIBarButtonItem) {
		currentAction = .AddNode
	}
	@IBAction func RemoveNodeTouched(sender: UIBarButtonItem) {
		currentAction = .RemoveNode
	}
	@IBAction func LinkTouched(sender: UIBarButtonItem) {
		currentAction = .Link
	}
	@IBAction func TrashTouched(sender: UIBarButtonItem) {
		drawingBoard.subviews.forEach({ subview in
			UIView.transitionWithView(subview, duration: 0.25, options: UIViewAnimationOptions.CurveEaseIn, animations: {
				subview.transform = CGAffineTransformScale(subview.transform, 0.1, 0.1)
			}) { (finished) in
				subview.removeFromSuperview()
			}
		})
		AudioServicesPlaySystemSound(removeSound!)
		self.currentNode = nil
		self.graph = Graph()
		self.currentAction = .AddNode
		componentsLabel.text = "0"
	}
	@IBAction func SearchTouched(sender: UIBarButtonItem) {
		graph.Scan()
		componentsLabel.text = "\(graph.connectedComponents.count)"
		graph.connectedComponents = []
		graph.nodes.forEach { $0.isVisited = false }
	}
	
	override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
		guard let currentAction = currentAction else { return }
		for touch in touches {
			let tapPoint = touch.locationInView(self.drawingBoard)
			switch currentAction {
			case .AddNode:
				self.addNode(tapPoint)
			case .RemoveNode:
				self.removeNode(tapPoint)
			case .Link:
				self.linkNodes(tapPoint)
			}
		}
	}
	
	func addNode(tapPoint: CGPoint) {
		let node = Node(name: "\(graph.nodes.count)", nodePosition: tapPoint)
		graph.nodes.append(node)
		let nodeView = NodeView(frame: CGRect(origin: CGPointMake(tapPoint.x - 25, tapPoint.y - 25), size: CGSize(width: 50, height: 50)), node: node)
		self.drawingBoard.addSubview(nodeView)
		nodeView.layer.anchorPoint = CGPointMake(0.5, 0.5)
		self.growShrinkAnimate(nodeView)
		AudioServicesPlaySystemSound(blipSound!)
	}
	
	func growShrinkAnimate(view: UIView) {
		UIView.transitionWithView(view, duration: 0.25, options: UIViewAnimationOptions.CurveEaseIn, animations: {
			view.transform = CGAffineTransformScale(view.transform, 2.0, 2.0)
		}) { finished in
			UIView.transitionWithView(view, duration: 0.25, options: UIViewAnimationOptions.CurveEaseOut, animations: {
				view.transform = CGAffineTransformScale(view.transform, 0.5, 0.5)
			}) { finished in
				guard let nodeView = view as? NodeView else { return }
				nodeView.showName()
			}
		}
	}
	
	func shrink(view: UIView) {
		UIView.transitionWithView(view, duration: 0.25, options: UIViewAnimationOptions.CurveEaseInOut, animations: {
			view.transform = CGAffineTransformScale(view.transform, 0.9, 0.9)
		}) { finished in
			guard let nodeView = view as? NodeView else { return }
			nodeView.showName()
		}
	}
	
	func grow(view: UIView) {
		UIView.transitionWithView(view, duration: 0.25, options: UIViewAnimationOptions.CurveEaseInOut, animations: {
			view.transform = CGAffineTransformScale(view.transform, 1.1, 1.1)
		}) { finished in }
	}
	
	func removeNode(tapPoint: CGPoint) {
		guard let nodeToRemove = checkIfNodeIsHit(tapPoint) else { return }
		UIView.transitionWithView(nodeToRemove, duration: 0.25, options: UIViewAnimationOptions.CurveEaseIn, animations: {
			nodeToRemove.transform = CGAffineTransformScale(nodeToRemove.transform, 0.1, 0.1)
		}) { (finished) in
			nodeToRemove.removeFromSuperview()
		}
	}
	
	func linkNodes(tapPoint: CGPoint) {
		if currentNode == nil {
			self.currentNode = checkIfNodeIsHit(tapPoint)
			guard let currentNode = self.currentNode else { return }
			grow(currentNode)
		} else {
			if let nextNode = checkIfNodeIsHit(tapPoint) {
				nextNode.node.ConnectsTo(currentNode!.node)
				
				let linkView = LinkView(frame: drawingBoard.bounds, nodeViewA: currentNode!, nodeViewB: nextNode)
				linkView.alpha = 0
				drawingBoard.insertSubview(linkView, atIndex: 0)
				
				UIView.animateWithDuration(0.25, animations: {
					linkView.alpha = 1
				})
				
				shrink(self.currentNode!)
				currentNode = nil
				AudioServicesPlaySystemSound(shlipSound!)
			}
		}
	}
	
	func checkIfNodeIsHit(tapPoint: CGPoint) -> NodeView? {
		for view in drawingBoard.subviews {
			if view is NodeView {
				if CGRectContainsPoint(view.frame, tapPoint) {
					return view as? NodeView
				}
			}
		}
		return nil
	}
}
