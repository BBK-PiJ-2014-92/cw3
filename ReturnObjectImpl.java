public class ReturnObjectImpl implements ReturnObject {
	private ErrorMessage currentError;
	private Object myObject;

	public ReturnObjectImpl(Object myObject) {
		currentError = ErrorMessage.NO_ERROR;
		this.myObject = myObject;
	}

	public boolean hasError() {
		if (currentError == ErrorMessage.NO_ERROR) {
			return false;
		}else {
			return true;
		}
	}

	public ErrorMessage getError() {
		if (hasError() == false) {
			return ErrorMessage.NO_ERROR;
		}else {
			return currentError;
		}
	}

	public Object getReturnValue() {
		if (hasError() == true) {
			return null;
		}else {
			return myObject;
		}
	}
}