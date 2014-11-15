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
		while (tempNode != null);
		return size;
	}

	public ReturnObject get(int index) {
		Node tempNode = listHead;
		ReturnObjectImpl linked = new ReturnObjectImpl(tempNode);
		linked.setErrorList(isEmpty(), size(), index);
		if (linked.getError() != ErrorMessage.NO_ERROR) {
			return linked;
		}else {
			for (int i = 0, i < index, i++) {
				tempNode = tempNode.getNextNode();
				linked = new ReturnObjectImpl(tempNode);
			}
			return linked;
		}
	}

