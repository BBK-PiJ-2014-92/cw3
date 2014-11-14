public class ArrayList implements List {
	private Object[] objectArray = new Object[10];
	private int size = 0;

	public boolean isEmpty() {
		return (size() == 0);
	}

	public int size() {
		return size;
	}

	public ReturnObject get(int index) {
		ReturnObjectImpl array = new ReturnObjectImpl(objectArray[index]);
		array.setErrorList(isEmpty(), size, index);
		return array;
	}

	public ReturnObject remove(int index) {
		ReturnObjectImpl array = new ReturnObjectImpl(objectArray[index]);
		array.setErrorList (isEmpty(), size, index);
		if (array.getError() != ErrorMessage.NO_ERROR) {
			return array;
		}else{
			for(int i = index; i < size(); i++) {
				objectArray[i] = objectArray[i+1];
			}
			size--;
			return array;
		}
	}

	public ReturnObject add(int index, Object item) {
		ReturnObjectImpl array = new ReturnObjectImpl(item);
		array.setErrorList (isEmpty(), size, index, item);
		if (array.getError() != ErrorMessage.NO_ERROR) {
			return array;
		}else {
			if (isFull()) {
				moreSpace();
			}
			for (int i = index; i < size(); i++) {
				objectArray[i+1] = objectArray[i];
			}
			objectArray[index] = item;
			size++;
			return null;
		}
	}

	public ReturnObject add(Object item) {
		ReturnObjectImpl array = new ReturnObjectImpl(item);
		array.setErrorList (isEmpty(), size, item);
		if (array.getError() != ErrorMessage.NO_ERROR) {
			return array;
		}else {
			if (isFull()) {
				moreSpace();
			}
			objectArray[size] = item;
			size++;
			return null;
		}
	}

	private boolean isFull() {
		return (objectArray.length - size < 1);
	}

	private void moreSpace() {
		Object[] bigObjectArray = new Object[size + 1];
		for (int i = 0; i < size; i++) {
			bigObjectArray[i] = objectArray[i];
		}
		objectArray = bigObjectArray;
	}
}