public class ImprovedStackImpl implements ImprovedStack {
	private List providedList;
	private AbstractStack providedStack;

	public ImprovedStackImpl() {
		providedList = new FunctionalLinkedList();
		providedStack = new StackImpl(providedList);
	}

	public boolean isEmpty() {
		return (providedStack.isEmpty());
	}

	public int size() {
		return providedStack.size();
	}

	public void push(Object item) {
		providedStack.push(item);
	}

	public ReturnObject top() {
		return providedStack.top();
	}

	public ReturnObject pop() {
		return providedStack.pop();
	}

	public ImprovedStack reverse() {
		ImprovedStack reversed = new ImprovedStackImpl();
		Object item;
		for (int i = size() - 1; i >= 0; i--) {
			item = providedStack.internalList.get(i).getReturnValue();
			reversed.push(item);
		}
		return reversed;
	}

	public void remove (Object object) {
		Object item;
		for (int i = 0; i < size(); i++) {
			item = providedStack.internalList.get(i).getReturnValue();
			if (item.equals(object)) {
				providedStack.internalList.remove(i);
				i--;
			}
		}
	}
}