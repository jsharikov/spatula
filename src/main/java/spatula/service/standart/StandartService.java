package spatula.service.standart;

import java.util.List;

import spatula.entity.standart.Standart;

public interface StandartService {

    void save(Standart standart);

    boolean existsByCode(String code);

    Standart get(Long id);

    Standart getByCode(String code);

    List<Standart> getAll();

}
