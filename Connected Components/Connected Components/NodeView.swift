import UIKit

class NodeView: UIView {
	var circle: UIBezierPath!
	var node: Node!
	
	init(frame: CGRect, node: Node) {
		super.init(frame: frame)
		self.node = node
		setupView()
	}
	
	required init?(coder aDecoder: NSCoder) {
		fatalError("init(coder:) has not been implemented")
	}
	
	func setupView() {
		self.circle = UIBezierPath(ovalInRect: CGRectInset(bounds, 1.5, 1.5))
		circle.lineWidth = 3
		self.backgroundColor = UIColor.clearColor()
		
		let nameLabel = UILabel()
		
		nameLabel.textAlignment = .Center
		nameLabel.text = node.name
		nameLabel.sizeToFit()
		nameLabel.center = CGPointMake(frame.width / 2, frame.height / 2)
		
		self.addSubview(nameLabel)
	}
	
	override func drawRect(rect: CGRect) {
		let strokeColor = UIColor.lightGrayColor()
		
		UIColor.whiteColor().setFill()
		circle.fill()
		
		strokeColor.setStroke()
		
		circle.stroke()
	}
}