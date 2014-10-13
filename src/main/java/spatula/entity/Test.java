package spatula.entity;

import java.io.Serializable;

/**
 * Тестовая таблица.
 *
 * @author Anastasiya_Trafimava
 *
 */

public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String address;
    
    private String telephone;

    private String mail;

    /**
     * Получает id.
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Устанавливает id.
     *
     * @param id идентификатор
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Получает name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает name.
     *
     * @param name наименование
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает address.
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Устанавливает address.
     *
     * @param address адрес
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Получает telephone.
     *
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Устанавливает telephone.
     *
     * @param telephone телефон
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Получает mail.
     *
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Устанавливает mail.
     *
     * @param mail e-mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

}
