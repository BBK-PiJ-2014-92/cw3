public class ArrayList implements List {
	private Object[] objectArray = new Object[10];

	public boolean isEmpty() {
		if(objectArray == null) {
			return true;
		}else {
			return false;
		}
	}

	public int size() {
		return objectArray.length();
	}

	public ReturnObject get(int index) {
		ReturnObjectImpl array = new ReturnObjectImpl(objectArray);
		if(objectArray.length() == 0) {
			array.setError(ErrorMessage.EMPTY_STRUCTURE);
			return array;
		}else if(index >= objectArray.length() || index < 0) {
			array.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return array;
		}else {
			return array;
		}
	}
}