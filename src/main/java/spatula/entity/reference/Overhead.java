package spatula.entity.reference;

import java.math.BigDecimal;

public class Overhead {

    private BigDecimal value;
    private Integer percent;

    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public Integer getPercent() {
        return percent;
    }
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

}
