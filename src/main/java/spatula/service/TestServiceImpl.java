package spatula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spatula.entity.Test;


/**
 * Реализация интерфейса для работы с тестовой таблицей.
 *
 * @author Anastasiya_Trafimava
 *
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public List<Test> findAll() {
        return null;
    }

    @Override
    public Test getById(Integer id) {
        Test entry = new Test();
        entry.setId(1);
        entry.setMail("entry@mail.ru");
        entry.setName("EntryName");
        entry.setTelephone("333");
        entry.setAddress("Belarus");
        return entry;
    }

    @Override
    public void save(Test t) {

    }

    @Override
    public void delete(Integer id) {
    }

}
