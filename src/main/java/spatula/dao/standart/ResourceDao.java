package spatula.dao.standart;

import java.util.List;

import spatula.dao.reference.Dao;
import spatula.entity.standart.Resource;

public interface ResourceDao extends Dao<Resource, Long> {

    Resource findByStandartId(Long standartId);

    List<Resource> findAllNotExclusion();
}
