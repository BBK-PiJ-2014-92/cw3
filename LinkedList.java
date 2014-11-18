public class LinkedList implements List {
	private Node listHead;
	private int size;

	public LinkedList() {
		listHead = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (listHead == null);
	}

	public int size() {
		return size;
	}

	public ReturnObject get(int index) {
		Node tempNode = listHead;
		ReturnObject linked = new ReturnObjectImpl(null);
		((ReturnObjectImpl)linked).setEmpty(isEmpty());
		((ReturnObjectImpl)linked).setOOB(size(), index);
		if (linked.getError() == ErrorMessage.NO_ERROR) {		
			for (int i = 0; i < index; i++) {
				tempNode = tempNode.getNextNode();
			}
			linked = new ReturnObjectImpl(tempNode.getValue());
		}
		return linked;
	}

	public ReturnObject remove(int index) {
		Node tempNode = listHead;
		ReturnObject linked = get(index);
		if (linked.getError() == ErrorMessage.NO_ERROR) {
			if (index == 0) {
				linked = new ReturnObjectImpl(listHead);
				listHead = listHead.getNextNode();
				size--;
			}else {
				for (int i = 0; i < index - 1; i++) {
					tempNode = tempNode.getNextNode();
				}
				Node removedNode = tempNode.getNextNode();
				tempNode.setNextNode(removedNode.getNextNode());
				removedNode.setNextNode(null);
				linked = new ReturnObjectImpl(removedNode.getValue());
				size--;
			}
		}
		return linked;
	}

	public ReturnObject add(int index, Object item) {
		Node tempNode = listHead;
		ReturnObject linked;
		if (index == 0 && isEmpty()) {
			linked.add(item);
		} else{ 
			linked = new ReturnObjectImpl(item);
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

		}
		return linked;
	}

	public ReturnObject add(Object item) {
		Node tempNode = listHead;
		Node newNode = new Node(item);
		ReturnObject linked = new ReturnObjectImpl(item);
		((ReturnObjectImpl)linked).setInvalid(item);
		if (linked.getError() == ErrorMessage.NO_ERROR) {
			if (listHead != null) {
				while (tempNode.getNextNode() != null) {
					tempNode = tempNode.getNextNode();
				}
				tempNode.setNextNode(newNode);
				linked = new ReturnObjectImpl(null);
				size++;
			}else {
				listHead = newNode;
				size++;
			}
		}
		return linked;
	}
}