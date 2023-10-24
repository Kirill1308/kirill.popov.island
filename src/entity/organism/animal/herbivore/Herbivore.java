package entity.organism.animal.herbivore;

import abstraction.entity.Reproducible;
import entity.organism.animal.Animal;

public abstract class Herbivore extends Animal implements Reproducible {
    public Herbivore(String name) {

        super(name, "Herbivore");
    }
}
