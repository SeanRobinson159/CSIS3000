import UIKit

class LinkView: UIView {
	var nodeViewA: NodeView?
	var nodeViewB: NodeView?
	
	init(nodeViewA: NodeView, nodeViewB: NodeView) {
		super.init(frame: CGRectZero)
		self.frame = self.getFrame(nodeViewA, nodeViewB: nodeViewB)
		
		self.nodeViewA = nodeViewA
		self.nodeViewB = nodeViewB
		self.backgroundColor = UIColor.clearColor()
	}
	
	func getFrame(nodeViewA: NodeView, nodeViewB: NodeView) -> CGRect {
		var frame = CGRectZero
		let nodeAPosition = nodeViewA.node.nodePosition
		let nodeBPosition = nodeViewB.node.nodePosition
		
		let originX = min(nodeAPosition.x, nodeBPosition.x)
		let originY = min(nodeAPosition.y, nodeBPosition.y)
		frame.origin = CGPointMake(originX, originY)
		
		let bottomX = max(nodeAPosition.x, nodeBPosition.x)
		let bottomY = max(nodeAPosition.y, nodeBPosition.y)
		
		frame.size = CGSize(width: abs(originX - bottomX), height: abs(originY - bottomY))
		
		return frame
	}
	
	required init?(coder aDecoder: NSCoder) {
		fatalError("init(coder:) has not been implemented")
	}
	
	override func drawRect(rect: CGRect) {
		guard nodeViewA != nil && nodeViewB != nil else { return }
		
		UIColor.blackColor().setStroke()
		
		let path = UIBezierPath()
		path.lineWidth = 3
		path.moveToPoint(nodeViewA!.node.nodePosition)
		path.addLineToPoint(nodeViewB!.node.nodePosition)
		finish(path)
		path.stroke()
	}
	
	func finish(path: UIBezierPath) {
//		let pathBounds = path.bounds
//		self.frame = pathBounds
//		self.frame.origin = CGPointMake(path.bounds.origin.x - path.lineWidth / 2, path.bounds.origin.y - path.lineWidth / 2)
		let transform = CGAffineTransformMakeTranslation(-(path.bounds.origin.x - path.lineWidth / 2), -(path.bounds.origin.y - path.lineWidth / 2))
		path.applyTransform(transform)
	}
}