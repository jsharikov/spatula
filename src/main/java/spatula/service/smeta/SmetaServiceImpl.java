package spatula.service.smeta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.smeta.SmetaDao;
import spatula.dao.smeta.WorkSmetaDao;
import spatula.entity.smeta.Smeta;
import spatula.entity.smeta.WorkSmeta;
import spatula.entity.standart.Work;
import spatula.service.standart.ResourceService;
import spatula.service.standart.WorkService;

@Service
public class SmetaServiceImpl implements SmetaService {

    @Autowired
    private SmetaDao smetaDao;
    @Autowired
    private WorkSmetaDao workSmetaDao;
    @Autowired
    private WorkService workService;
    @Autowired
    private ResourceService resourceService;

    @Override
    public void create(Smeta smeta) {
        smetaDao.create(smeta);
        createWorkSmetaList(smeta.getWorks(), smeta.getId());
    }

    private void createWorkSmetaList(List<WorkSmeta> works, Long smetaId) {
        createWorkSmetaList(works, smetaId, getMaxWorkQueueOrZero(smetaId));
    }

    private void createWorkSmetaList(List<WorkSmeta> works, Long smetaId, Integer offsetQueue) {
        for (int i = 0; i < works.size(); i++) {
            WorkSmeta workSmeta = works.get(i);
            workSmeta.setSmetaId(smetaId);
            workSmeta.setQueue(i + 1 + offsetQueue);
            //workSmetaDao.create(workSmeta);
            createWorkSmeta(workSmeta);
        }
    }

    @Override
    public Smeta get(Long id) {
        return smetaDao.read(id);
    }

    @Override
    public void update(Smeta smeta) {
        createWorkSmetaList(smeta.getWorks(), smeta.getId());
    }

    @Override
    public Integer getMaxWorkQueueOrZero(Long id) {
        Integer queue = smetaDao.findLastWorkQueue(id);
        if (queue == null) {
            return 0;
        }
        return queue;
    }

    private void createWorkSmeta(WorkSmeta workSmeta) {
        if (workSmeta.getWork() != null) {
            Work work = workSmeta.getWork();
            workService.save(work);
            workSmeta.setWorkId(work.getId());
        }
        workSmetaDao.create(workSmeta);
    }

    @Override
    public List<Smeta> getAll() {
        return smetaDao.findAll();
    }

}
