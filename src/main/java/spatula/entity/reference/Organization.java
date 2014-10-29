package spatula.entity.reference;

import spatula.entity.NamedEntity;

public class Organization extends NamedEntity {

	private static final long serialVersionUID = 8727780445040116880L;

	private Long orgFormId;

	private String bin;

	private String address;

	private Long bankAccountId;

	private String email;

	public Long getOrgFormId() {
		return orgFormId;
	}

	public void setOrgFormId(Long orgFormId) {
		this.orgFormId = orgFormId;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
