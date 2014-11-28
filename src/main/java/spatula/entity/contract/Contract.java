package spatula.entity.contract;

import spatula.entity.NamedEntity;

public class Contract extends NamedEntity {

	private static final long serialVersionUID = 6978860933348661575L;

	private String note;

	private String fileName;

	private byte[] content;

	private String mimeType;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

}
