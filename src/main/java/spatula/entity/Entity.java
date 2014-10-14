package spatula.entity;

import java.io.Serializable;

public class Entity implements Serializable {

    private static final long serialVersionUID = 5421995554660124563L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
