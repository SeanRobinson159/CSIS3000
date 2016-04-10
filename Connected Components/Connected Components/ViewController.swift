import UIKit

enum Action {
	case AddNode, RemoveNode, Link
}

class ViewController: UIViewController {
	@IBOutlet weak var drawingBoard: UIView!
	@IBOutlet weak var componentsLabel: UILabel!

	var currentAction: Action?
	var graph = Graph()
	var currentNode: NodeView?

	override func viewDidLoad() {
		super.viewDidLoad()
		currentAction = .AddNode
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
		drawingBoard.subviews.forEach({ $0.removeFromSuperview() })
		self.currentNode = nil
		self.graph = Graph()
		self.currentAction = .AddNode
		componentsLabel.text = "0"
	}
	@IBAction func SearchTouched(sender: UIBarButtonItem) {
		graph.Scan()
		componentsLabel.text = "\(graph.connectedComponents.count)"
		graph.connectedComponents = []
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
	}

	func removeNode(tapPoint: CGPoint) {
		checkIfNodeIsHit(tapPoint)?.removeFromSuperview()
	}

	func linkNodes(tapPoint: CGPoint) {
		if currentNode == nil {
			self.currentNode = checkIfNodeIsHit(tapPoint)
			self.currentNode?.circle.lineWidth = 5
			self.currentNode?.setNeedsDisplay()
		} else {
			if let nextNode = checkIfNodeIsHit(tapPoint) {
				nextNode.node.ConnectsTo(currentNode!.node)

				let linkView = LinkView(frame: drawingBoard.bounds, nodeViewA: currentNode!, nodeViewB: nextNode)
				drawingBoard.insertSubview(linkView, atIndex: 0)

				currentNode?.circle.lineWidth = 3
				self.currentNode?.setNeedsDisplay()
				currentNode = nil
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
