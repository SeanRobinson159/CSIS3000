import UIKit

class LinkView: UIView {
	var nodeViewA: NodeView?
	var nodeViewB: NodeView?
	
	init(frame: CGRect, nodeViewA: NodeView, nodeViewB: NodeView) {
		super.init(frame: frame)
		self.nodeViewA = nodeViewA
		self.nodeViewB = nodeViewB
		self.backgroundColor = UIColor.clearColor()
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
		path.stroke()
	}
}