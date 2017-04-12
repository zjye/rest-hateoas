package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public abstract class ResourceIdSupport<T> extends ResourceSupport {
    @JsonProperty("id")
    private T resourceId;

    public T getResourceId() {
        return resourceId;
    }

    public void setResourceId(T resourceId) {
        this.resourceId = resourceId;
    }
}
