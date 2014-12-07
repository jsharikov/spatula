package spatula.service.smeta;

import java.util.List;

import spatula.entity.smeta.Smeta;

public interface SmetaService {

    void create(Smeta smeta);

    void update(Smeta smeta);

    Smeta get(Long id);

    Integer getMaxWorkQueueOrZero(Long id);

    List<Smeta> getAll();
}
