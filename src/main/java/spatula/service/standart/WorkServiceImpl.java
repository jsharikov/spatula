package spatula.service.standart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.standart.ResourceWorkDao;
import spatula.dao.standart.WorkDao;
import spatula.entity.standart.ResourceWork;
import spatula.entity.standart.Standart;
import spatula.entity.standart.Work;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkDao workDao;
    @Autowired
    private StandartService standartService;
    @Autowired
    private ResourceWorkDao resourceWorkDao;
    @Autowired
    private ResourceService resourceService;

    @Override
    public void save(Work work) {
        //Standart standart = work.getStandart();
        Standart standart = standartService.getByCode(work.getStandart().getCode());
        if (standart == null) {
            standartService.save(work.getStandart());
            work.setStandartId(work.getStandart().getId());
        } else {
            work.setStandartId(standart.getId());
        }
        workDao.create(work);
        createResourceWorkList(work.getResources(), work.getId());
        /*if (work.getId() == null) {
            create(work);
        } else {
            update(work);
        }*/
    }

    private void createResourceWorkList(List<ResourceWork> resourceWorkList, Long workId) {
        for (int i = 0; i < resourceWorkList.size(); i++) {
            ResourceWork resourceWork = resourceWorkList.get(i);
            resourceWork.setQueue(i + 1);
            if (resourceWork.getResourceId() == null) {
                resourceService.saveWithStandart(resourceWork.getResource());
                resourceWork.setResourceId(resourceWork.getResource().getId());
            }
            resourceWork.setWorkId(workId);
            resourceWorkDao.create(resourceWork);
        }
    }

    private void create(Work work) {
        workDao.create(work);
    }

    private void update(Work work) {
        workDao.update(work);
    }

    @Override
    public List<Work> getAll() {
        return workDao.findAll();
    }

}
