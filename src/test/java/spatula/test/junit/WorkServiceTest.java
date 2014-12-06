package spatula.test.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spatula.entity.standart.Work;
import spatula.service.standart.WorkService;
import spatula.test.junit.factory.WorkEntityFactory;

public class WorkServiceTest extends AbstractServiceTest {

    @Autowired
    private WorkService workService;
    @Autowired
    private WorkEntityFactory workEntityFactory;

    private Work work;

    @Before
    public void before() {
        work = workEntityFactory.createWork();
    }

    @Test
    public void testCreate() {
        assertNotNull("Не удалось создать работу", work.getId());
    }
    
    @Test
    public void testGetAll() {
        assertSame(workService.getAll().size(), 2);
    }

}
