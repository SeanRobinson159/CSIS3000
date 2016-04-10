import UIKit

class Node: NSObject {
	let name: String
	var connectedNodes: [Node]
	var nodePosition: CGPoint
	var isVisited: Bool
	
	init(name: String, nodePosition: CGPoint) {
		self.name = name
		self.nodePosition = nodePosition
		self.connectedNodes = [Node]()
		self.isVisited = false
	}
	
	func ConnectsTo(node: Node) {
		self.connectedNodes.append(node)
		
		if !node.connectedNodes.contains(self) {
			node.connectedNodes.append(self)
		}
	}
	
	func RemoveConnection(node: Node) {
		if let index = connectedNodes.indexOf(node) {
			connectedNodes.removeAtIndex(index)
			if let index = node.connectedNodes.indexOf(self) {
				node.connectedNodes.removeAtIndex(index)
			}
		}
	}
}
