package spatula.entity.contract;

import java.io.Serializable;

import spatula.entity.NamedEntity;

public class ContractTemplate extends NamedEntity implements Serializable {

	private static final long serialVersionUID = 3635184091104469601L;

	private Long id;

	private byte[] content;

	private String mimeType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
