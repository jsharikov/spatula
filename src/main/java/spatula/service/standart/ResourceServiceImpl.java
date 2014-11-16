package spatula.service.standart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.standart.ResourceDao;
import spatula.entity.standart.Resource;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private StandartService standartService;

    @Override
    public void saveWithStandart(Resource resource) {
        standartService.save(resource.getStandart());
        resource.setStandartId(resource.getStandart().getId());
        save(resource);
    }

    @Override
    public void save(Resource resource) {
        if (resource.getId() == null) {
            create(resource);
        } else {
            update(resource);
        }
    }

    private void create(Resource resource) {
        resourceDao.create(resource);
    }

    private void update(Resource resource) {
        resourceDao.update(resource);
    }

    @Override
    public List<Resource> getAll() {
        return resourceDao.findAll();
    }

    @Override
    public Resource get(Long id) {
        return resourceDao.read(id);
    }

    @Override
    public Resource getByStandartId(Long standartId) {
        return resourceDao.findByStandartId(standartId);
    }
}
