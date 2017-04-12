package hello;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private String name;
    private List<Person> persons = new ArrayList<Person>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
