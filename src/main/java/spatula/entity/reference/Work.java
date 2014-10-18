package spatula.entity.reference;

import java.util.ArrayList;
import java.util.List;

import spatula.entity.NamedEntity;

public class Work extends NamedEntity {

    private static final long serialVersionUID = 103617646741523848L;

    private String code;
    private Long unitId;
    private CostWork costPerUnit = new CostWork();
    private CostWork totalCost = new CostWork();
    private Overhead overhead = new Overhead();
    private LaborCost workers = new LaborCost();
    private LaborCost machinists = new LaborCost();
    private List<WorkResource> resources = new ArrayList<>();

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
    public CostWork getCostPerUnit() {
        return costPerUnit;
    }
    public void setCostPerUnit(CostWork costPerUnit) {
        this.costPerUnit = costPerUnit;
    }
    public CostWork getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(CostWork totalCost) {
        this.totalCost = totalCost;
    }
    public Overhead getOverhead() {
        return overhead;
    }
    public void setOverhead(Overhead overhead) {
        this.overhead = overhead;
    }
    public LaborCost getWorkers() {
        return workers;
    }
    public void setWorkers(LaborCost workers) {
        this.workers = workers;
    }
    public LaborCost getMachinists() {
        return machinists;
    }
    public void setMachinists(LaborCost machinists) {
        this.machinists = machinists;
    }
    public List<WorkResource> getResources() {
        return resources;
    }
    public void setResources(List<WorkResource> resources) {
        this.resources = resources;
    }

}
