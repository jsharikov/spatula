package spatula.entity.standart;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import spatula.entity.NamedEntity;
import spatula.entity.reference.Unit;

public class Standart extends NamedEntity {

    private static final long serialVersionUID = 1030139045264958396L;

    @NotBlank
    private String code;
    @NotNull
    private Long unitId;
    private Unit unit;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Long getUnitId() {
        return unitId;
    }
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
    /*@NotBlank
    @Override
    public String getName() {
        return super.getName();
    }*/
    public Unit getUnit() {
        return unit;
    }
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

}
