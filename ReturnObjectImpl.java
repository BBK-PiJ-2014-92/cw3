public class ReturnObjectImpl implements ReturnObject {
	private ErrorMessage currentError;
	private Object myObject;

	public ReturnObjectImpl(Object myObject) {
		currentError = ErrorMessage.NO_ERROR;
		this.myObject = myObject;
	}

	public boolean hasError() {
		return (currentError != ErrorMessage.NO_ERROR);
	}

	public ErrorMessage getError() {
		return currentError;
	}

	public Object getReturnValue() {
		if (hasError()) {
			return null;
		}else {
			return myObject;
		}
	}

	public void setErrorList(boolean isEmpty, int size, int index, Object item) {
		if(isEmpty) {
			currentError = ErrorMessage.EMPTY_STRUCTURE;
		}else if (index >= size || index < 0) {
			currentError =  ErrorMessage.INDEX_OUT_OF_BOUNDS;
		}else if (item == null) {
			currentError = ErrorMessage.INVALID_ARGUMENT;
		}
	}

	public void setErrorList(boolean isEmpty, int size, int index) { //Without item
		Object item = "not null";
		setErrorList(isEmpty, size, index, item);
	}

	public void setErrorList(boolean isEmpty, int size, Object item) { //Without index
		int index = size--;
		setErrorList(isEmpty, size, index, item);
	}
}