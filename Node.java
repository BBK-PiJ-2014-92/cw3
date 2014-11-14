public class Node {
	private Object value;
	private Node next;

	public Node(Object value) {
		this.value = value;
		next = null;
	}

	public Object getValue() {
		return value;
	}

	public void setNext(Node newNode) {
		next = newNode;
	}

	public Node getNext() {
		return next;
	}
}