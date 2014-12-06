package spatula.web.mvc.contract;

import java.io.Serializable;

public class ContractForm implements Serializable {

	private static final long serialVersionUID = -2562674462418915041L;

	private String contractName;

	private String note;

	private Long templateId;

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
}
