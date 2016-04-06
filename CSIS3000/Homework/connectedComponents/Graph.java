package connectedComponents;

import java.util.ArrayList;

public class Graph {
	public ArrayList<Node> nodes;
	public ArrayList<ConnectedComponent> connectedComponents;

	public Graph() {
		this.nodes = new ArrayList<Node>();
		this.connectedComponents = new ArrayList<ConnectedComponent>();
	}

	public Graph(ArrayList<Node> nodes) {
		this.nodes = nodes;
		this.connectedComponents = new ArrayList<ConnectedComponent>();
	}

	public boolean Scan() {
		for (Node node : this.nodes) {
			if (!node.isVisited) {
				ArrayList<Node> temp = new ArrayList<Node>();
				this.connectedComponents.add(new ConnectedComponent(DFS(node, temp)));
			}
		}
		if (this.connectedComponents.size() > 0) {
			return true;
		}
		return false;
	}

	private ArrayList<Node> DFS(Node node, ArrayList<Node> subgraph) {
		for (Node connectedNode : node.connectedNodes) {
			if (!connectedNode.isVisited) {
				connectedNode.isVisited = true;
				subgraph.add(connectedNode);
				subgraph = DFS(connectedNode, subgraph);
			}
		}
		return subgraph;
	}
}
