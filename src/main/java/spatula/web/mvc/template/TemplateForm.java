package spatula.web.mvc.template;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import spatula.entity.template.Template;

public class TemplateForm implements Serializable {

	private static final long serialVersionUID = 6420727372762985794L;

	private Template template;

	private MultipartFile multiPartFile;

	public MultipartFile getMultiPartFile() {
		return multiPartFile;
	}

	public void setMultiPartFile(MultipartFile multiPartFile) {
		this.multiPartFile = multiPartFile;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}
}
