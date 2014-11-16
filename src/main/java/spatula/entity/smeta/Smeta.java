package spatula.entity.smeta;

import java.util.List;

import spatula.entity.Entity;
import spatula.entity.standart.Work;

public class Smeta extends Entity {

    private static final long serialVersionUID = -3358035361200913023L;

    private List<Work> works;

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

}
