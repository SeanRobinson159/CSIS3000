package connectedComponents;

import java.awt.Point;
import java.util.ArrayList;

public class Node {
	public String name;
	public ArrayList<Node> connectedNodes;
	public Point nodePosition;
	public boolean isVisited;

	public Node(String name, Point nodePosition) {
		if (nodePosition == null) {
			this.nodePosition = new Point(0, 0);
		} else {
			this.nodePosition = nodePosition;
		}
		this.name = name;
		this.connectedNodes = new ArrayList<Node>();
		this.connectedNodes.add(this);
		this.isVisited = false;
	}

	public Node(String name, Point nodePosition, ArrayList<Node> connectedNodes) {
		if (nodePosition == null) {
			this.nodePosition = new Point(0, 0);
		} else {
			this.nodePosition = nodePosition;
		}

		if (connectedNodes == null) {
			this.connectedNodes = new ArrayList<Node>();
		} else {
			this.connectedNodes = connectedNodes;
		}
		this.name = name;
		this.connectedNodes.add(this);
		this.isVisited = false;
	}

	public void ConnectsTo(Node node) {
		this.connectedNodes.add(node);
		if (!node.connectedNodes.contains(this)) {
			node.connectedNodes.add(this);
		}
	}
}
