package spatula.entity.standart;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import spatula.entity.Entity;

public class Resource extends Entity {

    private static final long serialVersionUID = 587237450059895963L;

    @NotNull
    private BigDecimal cost;
    private Long standartId;
    @Valid
    private Standart standart;
    private BigDecimal wageOfMachinist;
    @NotNull
    private Boolean machine;

    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    public Long getStandartId() {
        return standartId;
    }
    public void setStandartId(Long standartId) {
        this.standartId = standartId;
    }
    public Standart getStandart() {
        if (standart == null) {
            standart = new Standart();
        }
        return standart;
    }
    public void setStandart(Standart standart) {
        this.standart = standart;
    }
    public BigDecimal getWageOfMachinist() {
        return wageOfMachinist;
    }
    public void setWageOfMachinist(BigDecimal wageOfMachinist) {
        this.wageOfMachinist = wageOfMachinist;
    }
    public Boolean getMachine() {
        return machine;
    }
    public void setMachine(Boolean machine) {
        this.machine = machine;
    }

}
