package spatula.test.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spatula.entity.reference.Bank;
import spatula.service.reference.BankService;

@Ignore
public class BankServiceTest extends AbstractServiceTest {

	@Autowired
	private BankService bankService;

	private Bank bank;

	@Before
	public void before() {
		bank = new Bank();
		bank.setName("АО 'КАЗКОММЕРЦБАНК'");
		bankService.save(bank);
	}

	@Test
	public void testCreate() {
		assertNotNull(bank.getId());
	}

	@Test
	public void testGet() {
		assertNotNull(bankService.get(bank.getId()));
	}

	@Test
	public void testUpdate() {
		String newName = "АО 'Сбербанк'";
		bank.setName(newName);
		bankService.save(bank);
		assertEquals(newName, bankService.get(bank.getId()).getName());
	}

	@Test
	public void testDelete() {
		bankService.delete(bank.getId());
		assertNull(bankService.get(bank.getId()));
	}

	@Test
	public void testFindAll() {
		assertFalse(bankService.getAll().isEmpty());
	}
}
