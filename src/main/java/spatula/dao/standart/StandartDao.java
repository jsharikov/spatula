package spatula.dao.standart;

import spatula.dao.reference.Dao;
import spatula.entity.standart.Standart;

public interface StandartDao extends Dao<Standart, Long> {

    boolean existsByCode(String code);

    Standart findByCode(String code);

}
