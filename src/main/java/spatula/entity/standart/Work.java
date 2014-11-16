package spatula.entity.standart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import spatula.entity.Entity;

public class Work extends Entity {

    private static final long serialVersionUID = 8964412807713750452L;

    @NotNull
    private BigDecimal totalCost;
    @NotNull
    private BigDecimal wagesOfWorkers;
    @NotNull
    private BigDecimal operMachinesCost;
    @NotNull
    private BigDecimal includingWagesOfMachinists;
    @NotNull
    private Integer percent;
    private Long standartId;
    /*@Valid*/
    private Standart standart;
    private Long workTypeId;
    private WorkType workType;
    @Valid
    private List<ResourceWork> resources;

    public BigDecimal getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
    public BigDecimal getWagesOfWorkers() {
        return wagesOfWorkers;
    }
    public void setWagesOfWorkers(BigDecimal wagesOfWorkers) {
        this.wagesOfWorkers = wagesOfWorkers;
    }
    public BigDecimal getOperMachinesCost() {
        return operMachinesCost;
    }
    public void setOperMachinesCost(BigDecimal operMachinesCost) {
        this.operMachinesCost = operMachinesCost;
    }
    public BigDecimal getIncludingWagesOfMachinists() {
        return includingWagesOfMachinists;
    }
    public void setIncludingWagesOfMachinists(BigDecimal includingWagesOfMachinists) {
        this.includingWagesOfMachinists = includingWagesOfMachinists;
    }
    public Integer getPercent() {
        return percent;
    }
    public void setPercent(Integer percent) {
        this.percent = percent;
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
    public Long getWorkTypeId() {
        return workTypeId;
    }
    public void setWorkTypeId(Long workTypeId) {
        this.workTypeId = workTypeId;
    }
    public List<ResourceWork> getResources() {
        if (resources == null) {
            resources = new ArrayList<>();
        }
        return resources;
    }
    public void setResources(List<ResourceWork> resources) {
        this.resources = resources;
    }
    public WorkType getWorkType() {
        return workType;
    }
    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }
}
