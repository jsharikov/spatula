package spatula.service.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.reference.BankDao;
import spatula.entity.reference.Bank;

@Service
public class BankServiceImpl implements BankService {

    @Autowired(required = false)
    private BankDao bankDao;

	@Override
	public void save(Bank bank) {
		if (bank.getId() == null) {
			bankDao.create(bank);
		} else {
			bankDao.update(bank);
		}
	}

	@Override
	public Bank get(Long id) {
		return bankDao.read(id);
	}

	@Override
	public void delete(Long id) {
		bankDao.delete(id);
	}

	@Override
	public List<Bank> getAll() {
		return bankDao.findAll();
	}

}
