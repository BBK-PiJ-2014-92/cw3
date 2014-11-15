public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	public ReturnObject head() {
		ReturnObjectImpl result = new ReturnObjectImpl(get(0).getReturnValue());
		result.setErrorList(isEmpty(), size(), 0);
		return result;
	}

	public FunctionalList rest() {
		FunctionalLinkedList result = new FunctionalLinkedList();
		for (int i = 1; i < size(); i++) {
			result.add(get(i).getReturnValue());
		}
		return result;
	}
}