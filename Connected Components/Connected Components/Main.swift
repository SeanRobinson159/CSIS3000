import UIKit

class Main {
	
	func main() {
		let graph = makeAGraph();
		graph.Scan()
		for connectedComponent in graph.connectedComponents {
			print("Nodes: ");
			for node in connectedComponent.connectedNodes {
				print(node.name);
			}
			print(" are connected.");
		}
	}
	
	func makeAGraph() -> Graph {
		let graph = Graph()
		
		let a = Node(name: "A", nodePosition: CGPointMake(0, 0))
		let b = Node(name: "B", nodePosition: CGPointMake(3, 0))
		let c = Node(name: "C", nodePosition: CGPointMake(5, 2))
		
		let d = Node(name: "D", nodePosition: CGPointMake(1, 1))
		let e = Node(name: "E", nodePosition: CGPointMake(3, 2))
		let f = Node(name: "F", nodePosition: CGPointMake(1, 3))
		
		let g = Node(name: "G", nodePosition: CGPointMake(0, 4))
		let h = Node(name: "H", nodePosition: CGPointMake(2, 4))
		let i = Node(name: "I", nodePosition: CGPointMake(4, 4))
		
		a.ConnectsTo(b);
		b.ConnectsTo(c);
		
		d.ConnectsTo(e);
		e.ConnectsTo(f);
		
		g.ConnectsTo(h);
		h.ConnectsTo(i);
		
		graph.nodes.append(a);
		graph.nodes.append(b);
		graph.nodes.append(c);
		graph.nodes.append(d);
		graph.nodes.append(e);
		graph.nodes.append(f);
		graph.nodes.append(g);
		graph.nodes.append(h);
		graph.nodes.append(i);
		
		return graph;
	}
}