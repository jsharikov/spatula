package spatula.service.reference;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.reference.WorkDao;
import spatula.entity.reference.Work;
import spatula.parser.WorkParser;

@Service
public class WorkServiceImpl implements WorkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkServiceImpl.class);

    @Autowired
    private WorkDao workDao;

    @Override
    public void save(Work work) {
        if (existsByCode(work.getCode())) {
            LOGGER.error("Попытка добавить работу, шифр который уже существует");
        } else if (work.getId() == null) {
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

    @Override
    public void saveWorks(List<Work> works) {
        for (Work work : works) {
            save(work);
        }
    }

    @Override
    public boolean existsByCode(String code) {
        return workDao.readByCode(code) != null;
    }

}
