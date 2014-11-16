package spatula.entity.smeta;

import java.math.BigDecimal;

import spatula.entity.QueueEntity;

public class WorkSmeta extends QueueEntity {

    private static final long serialVersionUID = -7749309705832303286L;

    private Long workId;
    private Long smetaId;
    private BigDecimal quantity;

    public Long getWorkId() {
        return workId;
    }
    public void setWorkId(Long workId) {
        this.workId = workId;
    }
    public Long getSmetaId() {
        return smetaId;
    }
    public void setSmetaId(Long smetaId) {
        this.smetaId = smetaId;
    }
    public BigDecimal getQuantity() {
        return quantity;
    }
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

}
