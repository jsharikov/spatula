package spatula.service.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.reference.OrgFormDao;
import spatula.entity.reference.OrgForm;

@Service
public class OrgFormServiceImpl implements OrgFormService {

	@Autowired
	OrgFormDao orgFormDao;

	@Override
	public void save(OrgForm orgForm) {
        if (orgForm.getId() == null) {
        	orgFormDao.create(orgForm);
        } else {
        	orgFormDao.update(orgForm);
        }
	}

	@Override
	public OrgForm get(Long id) {
		return orgFormDao.read(id);
	}

	@Override
	public void delete(Long id) {
		orgFormDao.delete(id);
	}

	@Override
	public List<OrgForm> getAll() {
		return orgFormDao.findAll();
	}

}
