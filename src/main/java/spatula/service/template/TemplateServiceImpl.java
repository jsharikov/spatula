package spatula.service.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.template.TemplateDao;
import spatula.entity.template.Template;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateDao templateDao;

	@Override
	public void save(Template template) {
		if (template.getId() == null) {
			templateDao.create(template);
		} else {
			templateDao.update(template);
		}
	}

	@Override
	public Template get(Long id) {
		return templateDao.read(id);
	}

	@Override
	public void delete(Long id) {
		templateDao.delete(id);
	}

	@Override
	public List<Template> getAll() {
		return templateDao.findAll();
	}

}
