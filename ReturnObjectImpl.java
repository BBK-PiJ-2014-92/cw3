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

	public void setEmpty(boolean isEmpty){
		if (isEmpty) {
			currentError = ErrorMessage.EMPTY_STRUCTURE;
		}
	}
	
	public void setOOB(int size, int index){
		if (index < 0 || index >= size) {
			currentError = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		}
	}
	
	public void setInvalid(Object item){
		if (item == null) {
			currentError = ErrorMessage.INVALID_ARGUMENT;
		}
	}
}