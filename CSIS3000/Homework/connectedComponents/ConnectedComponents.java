package connectedComponents;

import java.awt.Point;
import java.util.ArrayList;

class ConnectedComponents {

	private static Graph graph;

	public static void main(String[] args) {
		
		graph = new Graph();
		
		Node a = new Node(new Point(10, 10));
		Node b = new Node(new Point(0, 10));
		Node c = new Node(new Point(5, 5));
		Node d = new Node(new Point(0, 5));

		b.addConnectedNode(d);
		a.addConnectedNode(b);
		a.addConnectedNode(c);
		c.addConnectedNode(b);
		

		graph.nodes.add(a);
		graph.nodes.add(b);
		graph.nodes.add(c);
		graph.nodes.add(d);
		
		dfs(a);
	}

	public static void dfs(Node u) {
		for (Node connectedNode : u.getConnectedNodes()) {
			if (!connectedNode.isVisited) {
				connectedNode.isVisited = true;
				System.out.println(connectedNode.nodePosition);

				dfs(connectedNode);
			}
		}

//		for (Node v : u.getConnectedNodes()) {
//			if (!v.isVisited) {
//				v.isVisited = true;
//				dfs(v);
//			}
//		}
	}
}

/*
 * dfs(node u) for each node v connected to u : if v is not visited : visited[v]
 * = true dfs(v)
 * 
 * 
 * for each node u: if u is not visited : visited[u] = true connected_component
 * += 1 dfs(u)
 */