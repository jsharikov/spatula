package spatula.service;

import java.util.List;

import spatula.entity.Test;


/**
 * Интерфейс для работы с тестовой таблицей.
 *
 * @author Anastasiya_Trafimava
 *
 */
public interface TestService {

    /**
     * Получить все записи.
     *
     * @return список всех записей
     */
    List<Test> findAll();

    /**
     * Получить запись по идентификатору.
     *
     * @param id идентификатор
     * @return запись
     */
    Test getById(Integer id);

    /**
     * Добавление/редактирование.
     *
     * @param t запись
     */
    void save(Test t);

    /**
     * Удаление записи.
     *
     * @param id идентификатор
     */
    void delete(Integer id);
}
