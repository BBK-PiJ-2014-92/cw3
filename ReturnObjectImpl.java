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

	public void setError(ErrorMessage error) {
		currentError = error;
	}
}