package spatula.service.reference;

import java.util.List;

import spatula.entity.reference.Work;
import spatula.service.CrudService;

public interface WorkService extends CrudService<Work, Long> {

    void saveWorks(List<Work> works);

    boolean existsByCode(String code);

}
