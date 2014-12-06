package spatula.entity.smeta;

import java.util.ArrayList;
import java.util.List;

import spatula.entity.Entity;

public class Smeta extends Entity {

    private static final long serialVersionUID = -3358035361200913023L;

    private List<WorkSmeta> works = new ArrayList<>();

    public List<WorkSmeta> getWorks() {
        return works;
    }

    public void setWorks(List<WorkSmeta> works) {
        this.works = works;
    }

}
