package entity.organism.plant;

import entity.organism.Organism;
import lombok.Getter;

@Getter
public abstract class Plant extends Organism {
    private final String name;

    public Plant(String name) {
        this.name = name;
    }

}
