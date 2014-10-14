package spatula.service.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.reference.WorkDao;
import spatula.entity.reference.Work;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkDao workDao;

    @Override
    public void save(Work work) {
        if (work.getId() == null) {
            workDao.create(work);
        } else {
            workDao.update(work);
        }
    }

    @Override
    public Work get(Long id) {
        return workDao.read(id);
    }

    @Override
    public void delete(Long id) {
        workDao.delete(id);
    }

    @Override
    public List<Work> getAll() {
        return workDao.findAll();
    }

}
