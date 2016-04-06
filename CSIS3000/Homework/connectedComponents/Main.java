package connectedComponents;

import java.awt.Point;

class Main {

	private static Graph graph;

	public static void main(String[] args) {

		graph = makeAGraph();
		if (graph.Scan()) {
			for (ConnectedComponent connectedComponent : graph.connectedComponents) {
				for (Node node : connectedComponent.connectedNodes) {
					System.out.print(node.name);
				}
				System.out.println();
			}
		}
	}

	private static Graph makeAGraph() {
		Graph graph = new Graph();
		Node a = new Node("A", new Point(0, 0));
		Node b = new Node("B", new Point(3, 0));
		Node c = new Node("C", new Point(5, 2));

		Node d = new Node("D", new Point(1, 1));
		Node e = new Node("E", new Point(3, 2));
		Node f = new Node("F", new Point(1, 3));

		Node g = new Node("G", new Point(0, 4));
		Node h = new Node("H", new Point(2, 4));
		Node i = new Node("I", new Point(4, 4));

		a.ConnectsTo(b);
		b.ConnectsTo(c);

		d.ConnectsTo(e);
		e.ConnectsTo(f);

		g.ConnectsTo(h);
		h.ConnectsTo(i);

		graph.nodes.add(a);
		graph.nodes.add(b);
		graph.nodes.add(c);
		graph.nodes.add(d);
		graph.nodes.add(e);
		graph.nodes.add(f);
		graph.nodes.add(g);
		graph.nodes.add(h);
		graph.nodes.add(i);

		return graph;
	}
}