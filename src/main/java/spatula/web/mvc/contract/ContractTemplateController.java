package spatula.web.mvc.contract;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlOptions;
import org.jopendocument.dom.OOUtils;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spatula.entity.contract.ContractTemplate;
import spatula.entity.template.Template;
import spatula.service.contract.ContractTemplateService;
import spatula.service.template.TemplateService;

@Controller
@RequestMapping("/documents/contract_template")
public class ContractTemplateController {

    private static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

	@Autowired
	private ContractTemplateService contractTempService;

	@Autowired
	private TemplateService templateService;

	// список всех разделов
	@ModelAttribute("nodes")
	public List<Template> templates() {
		return templateService.getAll();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String contractTempAll(Model model) {
		model.addAttribute("contractTemplate", contractTempService.getAll());
		return "contract_template/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String contractTemp(Model model) {
		model.addAttribute("contractTemplateForm", new ContractTemplateForm());
		return "contract_template/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveContract(
			@ModelAttribute(value = "contractTemplateForm") ContractTemplateForm contractTemplateForm,
			BindingResult result, Model model) throws Exception {
		
		ContractTemplate contractTemplate = new ContractTemplate();
		contractTemplate.setName(contractTemplateForm.getContractTemplateName());


		ByteArrayInputStream bin1 = new ByteArrayInputStream(templateService.get(contractTemplateForm.getNodeIds().get(0)).getContent());
		OPCPackage src1Package = OPCPackage.open(bin1);
		XWPFDocument src1Document = new XWPFDocument(src1Package);        
	    CTBody src1Body = src1Document.getDocument().getBody();

	    File templateFile = File.createTempFile("temp", ".docx");
	    OutputStream dest = new FileOutputStream(templateFile);
	    
	    for (int i = 1; i < contractTemplateForm.getNodeIds().size(); i++) {
	    	ByteArrayInputStream bin2 = new ByteArrayInputStream(templateService.get(contractTemplateForm.getNodeIds().get(i)).getContent());	
		    OPCPackage src2Package = OPCPackage.open(bin2);
		    XWPFDocument src2Document = new XWPFDocument(src2Package);
		    CTBody src2Body = src2Document.getDocument().getBody();   
		    appendBody(src1Body, src2Body);
	    }
	    
	    src1Document.write(dest);

	    OOUtils.open(templateFile);
	    
	    FileInputStream fis = new FileInputStream(templateFile);
	    contractTemplate.setContent(IOUtils.toByteArray(fis));
	    contractTemplate.setMimeType(CONTENT_TYPE);
		contractTempService.save(contractTemplate);
		
		return "redirect:/documents/contract_template";
	}

	private static void appendBody(CTBody src, CTBody append) throws Exception {
	    XmlOptions optionsOuter = new XmlOptions();
	    optionsOuter.setSaveOuter();
	    String appendString = append.xmlText(optionsOuter);
	    String srcString = src.xmlText();
	    String prefix = srcString.substring(0,srcString.indexOf(">")+1);
	    String mainPart = srcString.substring(srcString.indexOf(">")+1,srcString.lastIndexOf("<"));
	    String sufix = srcString.substring( srcString.lastIndexOf("<") );
	    String addPart = appendString.substring(appendString.indexOf(">") + 1, appendString.lastIndexOf("<"));
	    CTBody makeBody = CTBody.Factory.parse(prefix+mainPart+addPart+sufix);
	    src.set(makeBody);
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showFile(@PathVariable("id") Long contractTempId, Model model) throws IOException {
		ContractTemplate contractTemplate = contractTempService.get(contractTempId);
		File templateFile = File.createTempFile("temp", ".docx");
        FileCopyUtils.copy(contractTemplate.getContent(), templateFile);
		OOUtils.open(templateFile);
        return "redirect:/documents/contract_template";
    }
	
}
