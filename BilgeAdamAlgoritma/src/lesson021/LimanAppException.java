package lesson021;

public class LimanAppException extends RuntimeException {

	private ErrorType eErrorType;

	public LimanAppException(ErrorType eErrorType) {
		super(eErrorType.getMessage());
		this.eErrorType = eErrorType;
	}

	public ErrorType geteErrorType() {
		return eErrorType;
	}

	public void seteErrorType(ErrorType eErrorType) {
		this.eErrorType = eErrorType;
	}

}
