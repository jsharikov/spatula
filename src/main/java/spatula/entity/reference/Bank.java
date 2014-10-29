package spatula.entity.reference;

import spatula.entity.NamedEntity;

public class Bank extends NamedEntity {

	private static final long serialVersionUID = -7098252553366451707L;

	private String bik;

	public String getBik() {
		return bik;
	}

	public void setBik(String bik) {
		this.bik = bik;
	}

}
