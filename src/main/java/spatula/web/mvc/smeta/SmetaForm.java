package spatula.web.mvc.smeta;

import javax.validation.Valid;

import spatula.entity.smeta.Smeta;
import spatula.entity.smeta.WorkSmeta;

public class SmetaForm {

    private Smeta smeta = new Smeta();

    @Valid
    private WorkSmeta workSmeta;

    public Smeta getSmeta() {
        return smeta;
    }

    public void setSmeta(Smeta smeta) {
        this.smeta = smeta;
    }

    public WorkSmeta getWorkSmeta() {
        return workSmeta;
    }

    public void setWorkSmeta(WorkSmeta workSmeta) {
        this.workSmeta = workSmeta;
    }

}
