package spatula.entity.reference;

import spatula.entity.NamedEntity;

public class Organization extends NamedEntity {

	private static final long serialVersionUID = 8727780445040116880L;

	private Long orgFormId;

	private String bin;

	private String address;

	private String iik;

	private Long bankId;

	private String bik;

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

	public String getIik() {
		return iik;
	}

	public void setIik(String iik) {
		this.iik = iik;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBik() {
		return bik;
	}

	public void setBik(String bik) {
		this.bik = bik;
	}

}
