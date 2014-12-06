package spatula.service.smeta;

import spatula.entity.smeta.Smeta;

public interface SmetaService {

    void create(Smeta smeta);

    void update(Smeta smeta);

    Smeta get(Long id);

    Integer getMaxWorkQueueOrZero(Long id);
}
