package spatula.service.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.contract.ContractTemplateDao;
import spatula.entity.contract.ContractTemplate;

@Service
public class ContractTemplateServiceImpl implements ContractTemplateService {

	@Autowired
	private ContractTemplateDao templateDao;

	@Override
	public void save(ContractTemplate template) {
		if (template.getId() == null) {
			templateDao.create(template);
		} else {
			templateDao.update(template);
		}
	}

	@Override
	public ContractTemplate get(Long id) {
		return templateDao.read(id);
	}

	@Override
	public void delete(Long id) {
		templateDao.delete(id);
	}

	@Override
	public List<ContractTemplate> getAll() {
		return templateDao.findAll();
	}

}
