public class LinkedList implements List {
	private Node listHead;

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public int size() {
		int size = 0;
		Node tempNode = listHead;
		do{
			size++;
			tempNode = tempNode.getNextNode();
		}
		while (tempNode.getNextNode() != null);
		return size;
	}

	public ReturnObject get(int index) {
		Node tempNode = listHead;
		ReturnObjectImpl linked = new ReturnObjectImpl(tempNode);
		linked.setErrorList(isEmpty(), size(), index);
		if (linked.getError() != ErrorMessage.NO_ERROR) {
			return linked;
		}else {
			for (int i = 0; i < index; i++) {
				tempNode = tempNode.getNextNode();
				tempNode.setNextNode(null);
				linked = new ReturnObjectImpl(tempNode);
			}
			return linked;
		}
	}

	public ReturnObject remove(int index) {
		Node tempNode = listHead;
		ReturnObjectImpl linked = new ReturnObjectImpl(tempNode);
		linked.setErrorList(isEmpty(), size(), index);
		if (linked.getError() != ErrorMessage.NO_ERROR) {
			return linked;
		}else {
			if (index = 0) {
				listHead = listHead.getNextNode();
				return linked = new ReturnObjectImpl(listHead);
			}else {
				for (int i = 0; i < index - 1; i++) {
					tempNode = tempNode.getNextNode();
				}
				Node removedNode = tempNode.getNextNode();
				tempNode.setNextNode(removedNode.getNextNode());
				removedNode.setNextNode(null);
				return linked = new ReturnObjectImpl(removedNode);
			}
		}
	}

	public ReturnObject add(int index, Object item) {
		Node tempNode = listHead;
		ReturnObjectImpl linked = new ReturnObjectImpl(tempNode);
		linked.setErrorList(isEmpty(), size(), index, item);
		if (linked.getError() != ErrorMessage.NO_ERROR) {
			return linked;
		}else {
			Node newNode = new Node(item);
			if (index = 0) {
				newNode.setNextNode(tempNode);
				listHead = newNode;
			}else {
				for (int i = 0; i < index - 1; i++) {
					tempNode = tempNode.getNextNode();
				}
				newNode.setNextNode(tempNode.getNextNode());
				tempNode.setNextNode(newNode);
				return null;
			}
		}
	}

	public ReturnObject add(Object item) {
		Node tempNode = listHead;
		ReturnObjectImpl linked = new ReturnObjectImpl(tempNode);
		linked.setErrorList(isEmpty(), size(), item);
		if (linked.getError() != ErrorMessage.NO_ERROR) {
			return linked;
		}else {
			Node newNode = new Node(item);
			while (tempNode.getNextNode() != null) {
				tempNode = tempNode.getNextNode();
			}
			tempNode.setNextNode(newNode);
			return null;
		}
	}
}