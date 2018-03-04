package app.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by User on 26.02.2018.
 */

public class Item {
    private final int id;
    private final String name;

    @JsonCreator
    public Item(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId (){
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        return (this.id == ((Item) o).getId() && this.name.equals(((Item) o).getName()));
    }
}
