import UIKit

class Graph {
	var nodes: [Node]
	var connectedComponents: [ConnectedComponent]
	
	init() {
		self.nodes = []
		self.connectedComponents = []
	}
	
	init(nodes: [Node]) {
		self.nodes = nodes
		self.connectedComponents = []
	}
	
	func Scan() {
		for node in self.nodes {
			if !node.isVisited {
				let connectedNodes = DFS(node, connectedNodes: [])
				let connectedComponent = ConnectedComponent(connectedNodes: connectedNodes)
				self.connectedComponents.append(connectedComponent)
			}
		}
	}
	
	private func DFS(node: Node, connectedNodes: [Node]) -> [Node] {
		var temp = connectedNodes
		for node in node.connectedNodes {
			if !node.isVisited {
				node.isVisited = true
				temp.append(node)
				temp = DFS(node, connectedNodes: temp)
			}
		}
		return temp
	}
}