package spatula.service.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.reference.OrgTelephoneDao;
import spatula.entity.reference.OrgTelephone;

@Service
public class OrgTelephoneServiceImpl implements OrgTelephoneService {

	@Autowired
	private OrgTelephoneDao telephoneDao;

	@Override
	public void save(OrgTelephone orgTelephone) {
		if (orgTelephone.getId() == null) {
			telephoneDao.create(orgTelephone);
		} else {
			telephoneDao.update(orgTelephone);
		}
	}

	@Override
	public OrgTelephone get(Long id) {
		return telephoneDao.read(id);
	}

	@Override
	public void delete(Long id) {
		telephoneDao.delete(id);
	}

	@Override
	public List<OrgTelephone> getAll() {
		return telephoneDao.findAll();
	}

}
