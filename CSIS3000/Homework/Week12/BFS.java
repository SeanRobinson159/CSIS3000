package Week12;

public class BFS {

	public void breadthFirstSearch(Queue queue) {
		if (queue.isEmpty())
			return;

		Node node = (Node) queue.poll();

		if (node.right != null)
			queue.offer(node.right);

		if (node.left != null)
			queue.offer(node.left);

		breadthFirstSearch(queue);
	}
}
