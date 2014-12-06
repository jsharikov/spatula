package spatula.dao.smeta;

import spatula.dao.reference.Dao;
import spatula.entity.smeta.Smeta;

public interface SmetaDao extends Dao<Smeta, Long> {

    Integer findLastWorkQueue(Long id);
}
