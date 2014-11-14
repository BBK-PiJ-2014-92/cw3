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
		if (array.getError() != ErrorMessage.NO_ERROR) {
			return array.gerError();
		}else {
			return array.getReturnValue();
		}
	}

	public ReturnObject remove(int index) {
		ReturnObjectImpl array = new ReturnObjectImpl(objectArray[index]);
		array.setErrorList (isEmpty(), size, index);
		if (array.getError() != ErrorMessage.NO_ERROR) {
			return array.getError();
		}else{
			for(int i = index, i < size(), i++) {
				objectArray[i] = objectArray[i+1];
			}i--;
			return array.getReturnValue();
		}
	}

	public ReturnObject add(int index, Object item) {
		ReturnObjectImpl array = new ReturnObjectImpl(item);
		array.setErrorList (isEmpty(), size, index, item);
		if (array.getError() != ErrorMessage.NO_ERROR) {
			return array.getError();
		}else {
			for (int i = index, i < size(), i++) {
				objectArray[i+1] = objectArray[i];
			}objectArray[index] = item;
			i++;
			return null;
		}
	}

	public ReturnObject add(Object item) {
		ReturnObjectImpl array = new ReturnObjectImpl(item);
		array.setErrorList (isEmpty(), size, item);
		if (array.getError() != ErrorMessage.NO_ERROR) {
			return array.getError();
		}else {
			objectArray[size] = item;
			i++;
			return null;
		}
	}
}