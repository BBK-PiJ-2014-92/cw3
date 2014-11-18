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
		if(isFull()) {
			moreSpace();
		}
		ReturnObject array = new ReturnObjectImpl(null);
		((ReturnObjectImpl)array).setEmpty(isEmpty());
		((ReturnObjectImpl)array).setOOB(size(), index);
		if(array.getError() == ErrorMessage.NO_ERROR) {
			array = new ReturnObjectImpl(objectArray[index]);
		}
		return array;
	}

	public ReturnObject remove(int index) {
		ReturnObject array = get(index);
		if (array.getError() == ErrorMessage.NO_ERROR) {
			for(int i = index; i < size(); i++) {
				objectArray[i] = objectArray[i+1];
			}
			size--;
		}
		return array;
	}

	public ReturnObject add(int index, Object item) {
		ReturnObject array;
		if (index == 0 && isEmpty()) {
			array = add(item);
		}else {
			array = new ReturnObjectImpl(item);
			((ReturnObjectImpl)array).setOOB(size(), index);
			((ReturnObjectImpl)array).setInvalid(item);
			if(array.getError() == ErrorMessage.NO_ERROR){
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
		}

		return array;
	}
	

	public ReturnObject add(Object item) {
		ReturnObject array = new ReturnObjectImpl(item);
		((ReturnObjectImpl)array).setInvalid(item);
		if(array.getError() == ErrorMessage.NO_ERROR){
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