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
		ReturnObject array = new ReturnObjectImpl(objectArray[index]);
		if (isEmpty()) {
			((ReturnObjectImpl)array).setError(ErrorMessage.EMPTY_STRUCTURE);
		}else if (index < 0 || index >= size()) {
			((ReturnObjectImpl)array).setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		return array;
	}

	public ReturnObject remove(int index) {
		ReturnObject array = new ReturnObjectImpl(objectArray[index]);
		if (isEmpty()) {
			((ReturnObjectImpl)array).setError(ErrorMessage.EMPTY_STRUCTURE);
		}else if (index < 0 || index >= size()) {
			((ReturnObjectImpl)array).setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}else{
			for(int i = index; i < size(); i++) {
				objectArray[i] = objectArray[i+1];
			}
			size--;
		}
		return array;
	}

	public ReturnObject add(int index, Object item) {
		ReturnObject array = new ReturnObjectImpl(item);
		if (index < 0 || index >= size()) {
			((ReturnObjectImpl)array).setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}else if (item == null) {
			((ReturnObjectImpl)array).setError(ErrorMessage.INVALID_ARGUMENT);
		}else {
			if (isFull()) {
				moreSpace();
			}
			for (int i = index; i < size(); i++) {
				objectArray[i+1] = objectArray[i];
			}
			objectArray[index] = item;
			size++;
			array = new ReturnObjectImpl(null);
		}
		return array;
	}
	

	public ReturnObject add(Object item) {
		ReturnObject array = new ReturnObjectImpl(item);
		if (item == null) {
			((ReturnObjectImpl)array).setError(ErrorMessage.INVALID_ARGUMENT);
		}else{
			if (isFull()) {
				moreSpace();
			}
			objectArray[size()] = item;
			size++;
			array = new ReturnObjectImpl(null);
		}
		return array;
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