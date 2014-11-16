package spatula.entity.reference;

import spatula.entity.Entity;

public class BankAccount extends Entity {

	private static final long serialVersionUID = -7159032705117050458L;

	private Long bankId;

	private String iik;

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getIik() {
		return iik;
	}

	public void setIik(String iik) {
		this.iik = iik;
	}

}
