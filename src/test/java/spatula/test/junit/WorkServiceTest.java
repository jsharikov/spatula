package spatula.test.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spatula.entity.reference.Work;
import spatula.enums.UnitEnum;
import spatula.service.reference.WorkService;

public class WorkServiceTest extends AbstractServiceTest {

    @Autowired
    private WorkService workService;

    private Work work;

    @Before
    public void before() {
        work = new Work();
        work.setCode("Е0101-17-13test");
        work.setName("Разработка грунта 4 группы с погрузкой наавтомобили-"
                + "самосвалы экскаваторами с ковшом вместимостью 0,5 м3");
        work.setUnitId(UnitEnum.M3.getId());
        work.getCostPerUnit().setTotal(new BigDecimal(20));
        workService.save(work);
    }

    @Test
    public void testCreate() {
        assertNotNull(work.getId());
    }

    @Test
    public void testGet() {
        assertNotNull(workService.get(work.getId()));
    }

    @Test
    public void testUpdate() {
        String code = "Е0101-17-15test";
        work.setCode(code);
        workService.save(work);
        assertEquals(work.getCode(), workService.get(work.getId()).getCode());
    }

    @Test
    public void testDelete() {
        workService.delete(work.getId());
        assertNull(workService.get(work.getId()));
    }

    @Test
    public void testGetAll() {
        assertFalse(workService.getAll().isEmpty());
    }

}
