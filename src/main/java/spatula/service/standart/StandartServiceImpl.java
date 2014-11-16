package spatula.service.standart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spatula.dao.standart.StandartDao;
import spatula.entity.standart.Standart;

@Service
public class StandartServiceImpl implements StandartService {

    @Autowired
    private StandartDao standartDao;

    @Override
    public void save(Standart standart) {
        if (!existsByCode(standart.getCode()) && standart.getId() == null) {
            create(standart);
        } else {
            update(standart);
        }
    }

    private void create(Standart standart) {
        standartDao.create(standart);
    }

    private void update(Standart standart) {
        standartDao.update(standart);
    }

    @Override
    public boolean existsByCode(String code) {
        return standartDao.existsByCode(code);
    }

    @Override
    public Standart get(Long id) {
        return standartDao.read(id);
    }

    @Override
    public Standart getByCode(String code) {
        return standartDao.findByCode(code);
    }

    @Override
    public List<Standart> getAll() {
        return standartDao.findAll();
    }
}
