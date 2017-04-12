package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

public abstract class Person extends ResourceSupport {
    private String name;
    @JsonProperty("id")
    private UUID resourceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID id) {
        this.resourceId = id;
    }
}
