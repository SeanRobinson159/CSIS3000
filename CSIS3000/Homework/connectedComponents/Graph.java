package connectedComponents;

import java.util.ArrayList;

public class Graph {
	public ArrayList<Node> nodes;
	public boolean isConnectedGraph;
	
	public Graph() {
		this.nodes = new ArrayList<Node>();
	}
	
	public Graph(ArrayList<Node> nodes){
		this.nodes = nodes;
	}
}
