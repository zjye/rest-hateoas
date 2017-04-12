package hello;

import java.util.UUID;

public abstract class Person extends ResourceIdSupport<UUID> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
