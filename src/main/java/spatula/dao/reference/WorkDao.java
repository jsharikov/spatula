package spatula.dao.reference;

import spatula.entity.reference.Work;

public interface WorkDao extends Dao<Work, Long> {

    Work readByCode(String code);

}
