public class Node {
	private Object value;
	private Node nextNode;

	public Node(Object value) {
		this.value = value;
		nextNode = null;
	}

	public Object getValue() {
		return value;
	}

	public void setNextNode(Node newNode) {
		nextNode = newNode;
	}

	public Node getNextNode() {
		return nextNode;
	}
}