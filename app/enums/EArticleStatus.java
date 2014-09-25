package enums;

public enum EArticleStatus {

	NULL("0",""), DDRAFT("01", "草稿"), ARCHIVE("02", "归档"), DELETED("03","已删除");

	private String text;
	private String code;

	private EArticleStatus(String code, String text) {
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
