package spatula.test.junit.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spatula.entity.standart.ResourceWork;
import spatula.entity.standart.Work;
import spatula.service.standart.WorkService;

@Component
public class WorkEntityFactory {

    @Autowired
    private WorkService workService;
    @Autowired
    private ResourceEntityFactory resourceEntityFactory;
    @Autowired
    private StandartEntityFactory standartEntityFactory;

    public Work createWork() {
        Work work = new Work();
        work.setPercent(97);
        work.setTotalCost(new BigDecimal(100));
        work.setStandart(standartEntityFactory.createStandart());
        work.setResources(getResourceWorkList());
        workService.save(work);
        return work;
    }

    private List<ResourceWork> getResourceWorkList() {
        List<ResourceWork> resourceWorkList = new ArrayList<>();
        ResourceWork resourceWork = new ResourceWork();
        resourceWork.setQuantity(new BigDecimal(0.3));
        resourceWork.setQueue(1);
        resourceWork.setResourceId(resourceEntityFactory.createResource().getId());
        resourceWorkList.add(resourceWork);
        return resourceWorkList;
    }

}
