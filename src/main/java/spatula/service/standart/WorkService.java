package spatula.service.standart;

import java.util.List;

import spatula.entity.standart.Work;

public interface WorkService {

    void save(Work work);

    List<Work> getAll();

}
