package connectedComponents;

import java.awt.Point;
import java.util.ArrayList;

public class Node {

	public ArrayList<Node> connectedNodes;
	public Point nodePosition;
	public boolean isVisited;

	public Node(Point nodePosition) {
		if (nodePosition == null) {
			this.nodePosition = new Point(0, 0);
		} else {
			this.nodePosition = nodePosition;
		}
		this.connectedNodes = new ArrayList<Node>();
		this.connectedNodes.add(this);
		this.isVisited = false;
	}

	public Node(Point nodePosition, ArrayList<Node> connectedNodes) {
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
		this.connectedNodes.add(this);
		this.isVisited = false;
	}

	public void addConnectedNode(Node node) {
		this.connectedNodes.add(node);
	}

	public ArrayList<Node> getConnectedNodes() {
		return connectedNodes;
	}

	public Point getNodePosition() {
		return nodePosition;
	}

}
