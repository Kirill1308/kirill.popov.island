package entity.organism.animal.predator;

import abstraction.entity.Reproducible;
import entity.organism.animal.Animal;

public abstract class Predator extends Animal implements Reproducible {
    public Predator(String name) {
        super(name, "Predator");
    }
}
