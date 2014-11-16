package spatula.test.junit.factory;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spatula.entity.standart.Resource;
import spatula.service.standart.ResourceService;

@Component
public class ResourceEntityFactory {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private StandartEntityFactory standartEntityFactory;

    public Resource createResource() {
        Resource resource = new Resource();
        resource.setCost(new BigDecimal(100));
        resource.setStandartId(standartEntityFactory.createStandart().getId());
        resourceService.save(resource);
        return resource;
    }

}
