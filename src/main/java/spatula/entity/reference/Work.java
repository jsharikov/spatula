package spatula.entity.reference;

import spatula.entity.NamedEntity;

public class Work extends NamedEntity {

    private static final long serialVersionUID = 103617646741523848L;

    private String code;
    private Long unitId;

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

}
