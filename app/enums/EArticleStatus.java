package enums;

public enum EArticleStatus {

	NULL("", ""), DDRAFT("m", "草稿"), ARCHIVE("p", "发布"), DELETED("d", "已删除");

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
