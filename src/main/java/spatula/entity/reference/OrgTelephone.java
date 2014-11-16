package spatula.entity.reference;

import spatula.entity.Entity;

public class OrgTelephone extends Entity {

	private static final long serialVersionUID = -6793918483965355113L;

	private String telephone;

	private boolean fax;

	private Long orgId;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isFax() {
		return fax;
	}

	public void setFax(boolean fax) {
		this.fax = fax;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

}
