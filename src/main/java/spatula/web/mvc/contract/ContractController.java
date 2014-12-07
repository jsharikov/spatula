package spatula.web.mvc.contract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jopendocument.dom.OOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spatula.entity.contract.Contract;
import spatula.entity.contract.ContractTemplate;
import spatula.entity.reference.Organization;
import spatula.service.contract.ContractTemplateService;
import spatula.service.reference.OrganizationService;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

@Controller
@RequestMapping("/documents/contract")
public class ContractController {

	private static final Long ORG_ID = new Long(-1);

	@Autowired
	private ContractTemplateService contractTemplateService;

	@Autowired
	private OrganizationService organizationService;

	// список всех шаблонов
	@ModelAttribute("contractTemp")
	public List<ContractTemplate> templates() {
		return contractTemplateService.getAll();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String contractAll(Model model) {
		return "contract/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String contract(Model model) {
		model.addAttribute("contractForm", new ContractForm());
		return "contract/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveContract(
			@ModelAttribute(value = "contractForm") ContractForm contractForm,
			BindingResult result, Model model) {
		Contract contract = generateContract(contractForm);
		try {
		File templateFile = File.createTempFile("contract", ".docx");
		FileCopyUtils.copy(contract.getContent(), templateFile);
		OOUtils.open(templateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/documents/contract";
	}

	private Contract generateContract(ContractForm contractForm) {
		File resultFile = null;
		try {
			ContractTemplate template = contractTemplateService.get(contractForm.getTemplateId());
			File templateFile = File.createTempFile("template", ".docx");
	        FileCopyUtils.copy(template.getContent(), templateFile);

			InputStream in = new FileInputStream(templateFile);
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(
					in, TemplateEngineKind.Velocity);

			IContext context = report.createContext();
			
			//заполняем данные об организации
			Organization org = organizationService.get(ORG_ID);
			context.put("org", org);

			resultFile = File.createTempFile("contract", ".docx");
			OutputStream out = new FileOutputStream(resultFile);
			report.process(context, out);
		} catch (XDocReportException | IOException e) {
			e.printStackTrace();
		}
		Contract contract = new Contract();
		contract.setName(contractForm.getContractName());
		contract.setNote(contractForm.getNote());
		contract.setMimeType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		try {
			contract.setContent(FileUtils.readFileToByteArray(resultFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contract;
	}
}
