package spatula.test.junit;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spatula.entity.standart.Resource;
import spatula.entity.standart.Standart;
import spatula.enums.UnitEnum;
import spatula.service.standart.ResourceService;
import spatula.service.standart.StandartService;

public class ResourceServiceTest extends AbstractServiceTest {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private StandartService standartService;

    private Resource resource;

    @Before
    public void before() {
        resource = new Resource();
        Standart standart = new Standart();
        standart.setCode("258 С test");
        standart.setName("Бульдозеры 79 кВт /108 л.с./");
        standart.setUnitId(UnitEnum.MACHINE_HOUR.getId());
        resource.setStandart(standart);
        resource.setCost(new BigDecimal(882));

        resourceService.saveWithStandart(resource);
    }

    @Test
    public void testCreateWithNewStandart() {
        assertNotNull("Не удалось создать ресурс", resource.getId());
    }

    @Test
    public void testCreateWithExistsStandart() {
        Standart standart = new Standart();
        standart.setCode("258 С test two");
        standart.setName("Бульдозеры 79 кВт /108 л.с./");
        standart.setUnitId(UnitEnum.MACHINE_HOUR.getId());
        standartService.save(standart);

        Resource res = new Resource();
        res.setCost(new BigDecimal(882));
        res.setStandartId(standart.getId());
        resourceService.save(res);
        assertNotNull("Не удалось создать ресурс", res.getId());
    }
}
