package spatula.entity.standart;

import java.math.BigDecimal;

import spatula.entity.QueueEntity;

public class ResourceWork extends QueueEntity {

    private static final long serialVersionUID = 2336726518283104889L;

    private Long resourceId;
    private Long workId;
    private BigDecimal quantity;
    private Resource resource;

    public Long getResourceId() {
        return resourceId;
    }
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Long getWorkId() {
        return workId;
    }
    public void setWorkId(Long workId) {
        this.workId = workId;
    }
    public BigDecimal getQuantity() {
        return quantity;
    }
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    public Resource getResource() {
        if (resource == null) {
            resource = new Resource();
        }
        return resource;
    }
    public void setResource(Resource resource) {
        this.resource = resource;
    }

}
