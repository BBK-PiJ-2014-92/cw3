public class StackImpl extends AbstractStack implements Stack {
	private int size;

	public StackImpl(List list) {
		super(list);
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public int size() {
		return size;
	}

	public void push(Object item) {
		internalList.add(item);
		size++;
	}

	public ReturnObject top() {
		return internalList.get(size - 1);
	}

	public ReturnObject pop() {
		ReturnObject result = internalList.remove(size - 1);
		size--;
		return result;
	}
}