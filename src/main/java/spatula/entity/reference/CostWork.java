package spatula.entity.reference;

import java.math.BigDecimal;

public class CostWork {

    private BigDecimal total;
    private BigDecimal wagesOfWorkers;
    private BigDecimal operMachines;
    private BigDecimal includingWagesOfMachinists;

    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public BigDecimal getWagesOfWorkers() {
        return wagesOfWorkers;
    }
    public void setWagesOfWorkers(BigDecimal wagesOfWorkers) {
        this.wagesOfWorkers = wagesOfWorkers;
    }
    public BigDecimal getOperMachines() {
        return operMachines;
    }
    public void setOperMachines(BigDecimal operMachines) {
        this.operMachines = operMachines;
    }
    public BigDecimal getIncludingWagesOfMachinists() {
        return includingWagesOfMachinists;
    }
    public void setIncludingWagesOfMachinists(BigDecimal includingWagesOfMachinists) {
        this.includingWagesOfMachinists = includingWagesOfMachinists;
    }

}
