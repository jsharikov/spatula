package spatula.entity.reference;

import java.math.BigDecimal;

public class LaborCost {

    private BigDecimal item;
    private BigDecimal total;

    public BigDecimal getItem() {
        return item;
    }
    public void setItem(BigDecimal item) {
        this.item = item;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
