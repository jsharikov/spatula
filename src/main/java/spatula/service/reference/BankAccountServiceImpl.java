package spatula.service.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.reference.BankAccountDao;
import spatula.entity.reference.BankAccount;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountDao bankAccountDao;

	@Override
	public void save(BankAccount bankAccount) {
		if (bankAccount.getId() == null) {
			bankAccountDao.create(bankAccount);
		} else {
			bankAccountDao.update(bankAccount);
		}
	}

	@Override
	public BankAccount get(Long id) {
		return bankAccountDao.read(id);
	}

	@Override
	public void delete(Long id) {
		bankAccountDao.delete(id);
	}

	@Override
	public List<BankAccount> getAll() {
		return bankAccountDao.findAll();
	}

}
