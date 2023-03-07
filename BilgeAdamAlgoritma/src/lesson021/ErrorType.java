package lesson021;

public enum ErrorType {
	
	OUT_OF_BOUNDS(1001,"Sınırların dışında"),
	SEAT_ALREADY_OCCUPIED(1002,"Seçilen yer dolu"),
	TOO_LOW_WEIGHT(1003,"100 Kg Altı yük kabul edilmiyor!"),
	OUT_OF_SHIFT_DAY(1004,"Cuma günleri Ürün kabul etmiyoruz"),
	EXPIRED_DATE(1005,"Geçmiş bir tarih giremezsiniz");
	
	private String message;
	private int code;

	ErrorType() {
		
	}

	public String getMessage() {
		return message;
	}
	
	

	private ErrorType(int code,String message) {
		this.message = message;
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	

}
