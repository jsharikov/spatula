package spatula.web.mvc.contract;

import java.io.Serializable;
import java.util.List;

public class ContractTemplateForm implements Serializable {

	private static final long serialVersionUID = -7689637444500572543L;

	private String contractTemplateName;

	private List<Long> nodeIds;

	public String getContractTemplateName() {
		return contractTemplateName;
	}

	public void setContractTemplateName(String contractTemplateName) {
		this.contractTemplateName = contractTemplateName;
	}

	public List<Long> getNodeIds() {
		return nodeIds;
	}

	public void setNodeIds(List<Long> nodeIds) {
		this.nodeIds = nodeIds;
	}
}
