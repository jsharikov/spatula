package spatula.web.mvc.template;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jopendocument.dom.OOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spatula.entity.template.Template;
import spatula.service.template.TemplateService;

@Controller
@RequestMapping("/documents/template")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;

	@RequestMapping(value = "", method = RequestMethod.GET)
    public String showTemplate(Model model) {
        List<Template> templates = templateService.getAll();
        model.addAttribute("templates", templates);
        return "template/list";
    }

	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addTemplate(Model model) {
		model.addAttribute("templateForm", new TemplateForm());
        return "template/create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveResource(@ModelAttribute(value = "templateForm") TemplateForm templateForm, BindingResult result,
            Model model) {
		templateService.save(convertTemplateForm(templateForm));
        return "redirect:/documents/template";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long templateId, Model model) {
		TemplateForm templateForm = new TemplateForm();
		templateForm.setTemplate(templateService.get(templateId));
        model.addAttribute("templateForm", templateForm);
        return "template/update";
    }

	private Template convertTemplateForm(TemplateForm templateForm) {
		Template template = templateForm.getTemplate();
		try {
			template.setFileName(templateForm.getMultiPartFile().getOriginalFilename());
			template.setContent(templateForm.getMultiPartFile().getBytes());
			template.setMimeType(templateForm.getMultiPartFile().getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
		return template;
	}
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showFile(@PathVariable("id") Long templateId, Model model) throws IOException {
		Template template = templateService.get(templateId);
		File templateFile = File.createTempFile("temp", ".docx");
        FileCopyUtils.copy(template.getContent(), templateFile);
		OOUtils.open(templateFile);
        return "redirect:/documents/template";
    }
}
