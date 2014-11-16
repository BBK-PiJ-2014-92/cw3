public abstract class AbstractList implements List{
	private List listType;

	public AbstractList(List listType) {
		this.listType = listType;
	}

	public boolean isEmpty() {
		return listType.isEmpty();
	}

	public ReturnObject get(int index) {
		return listType.get(index);
	}

	public int size() {
		return listType.size();
	}

	public ReturnObject remove(int index) {
		return listType.remove(index);
	}

	public ReturnObject add(int index, Object item) {
		return listType.add(index, item);
	}

	public ReturnObject add(Object item) {
		return listType.add(item);
	}

	public List getListType() {
		return listType;
	}
}