package connectedComponents;

import java.util.ArrayList;

public class ConnectedComponent {
	public ArrayList<Node> connectedNodes;

	public ConnectedComponent() {
		this.connectedNodes = new ArrayList<Node>();
	}

	public ConnectedComponent(ArrayList<Node> connectedNodes) {
		this.connectedNodes = connectedNodes;
	}

}
