package enums;

public enum EPermission {

	NULL("0",""), PUBLIC("01", "公开"), PRIVATE("02", "个人");

	private String text;
	private String code;

	private EPermission(String code, String text) {
		this.setCode(code);
		this.setText(text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
