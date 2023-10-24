package entity.organism.animal;

import abstraction.entity.Eatable;
import abstraction.entity.Movable;
import entity.organism.Organism;

public abstract class Animal extends Organism implements Movable, Eatable {
    public String name;
    public String category;

    public Animal(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public void move() {

    }

    @Override
    public void eat() {

    }

}
