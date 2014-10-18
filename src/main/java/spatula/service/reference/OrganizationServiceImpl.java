package spatula.service.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.reference.OrganizationDao;
import spatula.entity.reference.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationDao orgDao;

	@Override
	public void save(Organization org) {
		if (org.getId() == null) {
			orgDao.create(org);
		} else {
			orgDao.update(org);
		}
	}

	@Override
	public Organization get(Long id) {
		return orgDao.read(id);
	}

	@Override
	public void delete(Long id) {
		orgDao.delete(id);
	}

	@Override
	public List<Organization> getAll() {
		return orgDao.findAll();
	}

}
