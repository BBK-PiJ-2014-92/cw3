public class LinkedList implements List {
	private Node listHead;
	private int size;

	public LinkedList() {
		listHead = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public int size() {
		return size;
	}

	public ReturnObject get(int index) {
		Node tempNode = listHead;
		ReturnObject linked = new ReturnObjectImpl(tempNode);
		((ReturnObjectImpl)linked).setEmpty(isEmpty());
		((ReturnObjectImpl)linked).setOOB(size(), index);
		if (linked.getError() == ErrorMessage.NO_ERROR) {		
			for (int i = 0; i < index; i++) {
				tempNode = tempNode.getNextNode();
			}
			linked = new ReturnObjectImpl(tempNode);
		}
		return linked;
	}

	public ReturnObject remove(int index) {
		Node tempNode = listHead;
		ReturnObject linked = new ReturnObjectImpl(tempNode);
		((ReturnObjectImpl)linked).setEmpty(isEmpty());
		((ReturnObjectImpl)linked).setOOB(size(), index);
		if (linked.getError() == ErrorMessage.NO_ERROR) {
			if (index == 0) {
				listHead = listHead.getNextNode();
				linked = new ReturnObjectImpl(listHead);
				size--;
			}else {
				for (int i = 0; i < index - 1; i++) {
					tempNode = tempNode.getNextNode();
				}
				Node removedNode = tempNode.getNextNode();
				tempNode.setNextNode(removedNode.getNextNode());
				removedNode.setNextNode(null);
				linked = new ReturnObjectImpl(removedNode);
				size--;
			}
		}
		return linked;
	}

	public ReturnObject add(int index, Object item) {
		Node tempNode = listHead;
		ReturnObject linked = new ReturnObjectImpl(tempNode);
		((ReturnObjectImpl)linked).setOOB(size(), index);
		((ReturnObjectImpl)linked).setInvalid(item);
		if (linked.getError() == ErrorMessage.NO_ERROR) {
			Node newNode = new Node(item);
			if (index == 0) {
				newNode.setNextNode(tempNode);
				listHead = newNode;
				linked = new ReturnObjectImpl(null);
				size++;
			}else {
				for (int i = 0; i < index - 1; i++) {
					tempNode = tempNode.getNextNode();
				}
				newNode.setNextNode(tempNode.getNextNode());
				tempNode.setNextNode(newNode);
				linked = new ReturnObjectImpl(null);
				size++;
			}
		}
		return linked;
	}

	public ReturnObject add(Object item) {
		Node tempNode = listHead;
		ReturnObject linked = new ReturnObjectImpl(tempNode);
		((ReturnObjectImpl)linked).setInvalid(item);
		if (linked.getError() == ErrorMessage.NO_ERROR) {
			Node newNode = new Node(item);
			while (tempNode.getNextNode() != null) {
				tempNode = tempNode.getNextNode();
			}
			tempNode.setNextNode(newNode);
			linked = new ReturnObjectImpl(null);
			size++;
		}
		return linked;
	}
}