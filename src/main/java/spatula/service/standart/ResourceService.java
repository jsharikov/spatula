package spatula.service.standart;

import java.util.List;

import spatula.entity.standart.Resource;

public interface ResourceService {

    void saveWithStandart(Resource resource);

    void save(Resource resource);

    List<Resource> getAll();

    Resource get(Long id);

    Resource getByStandartId(Long standartId);

    List<Resource> getAllNotExclusion();

}
