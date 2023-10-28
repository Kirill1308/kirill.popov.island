package entity.organism.animal;

import abstraction.entity.Eatable;
import abstraction.entity.Movable;
import entity.map.IslandCell;
import entity.organism.Organism;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class Animal extends Organism implements Movable, Eatable {
    IslandCell islandCell = new IslandCell();

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
        List<Animal> animalsOnCell = islandCell.getAnimals();

        for (Animal otherAnimal : animalsOnCell) {
            if (otherAnimal != this) {
                if (isPredator() && otherAnimal.isHerbivore()) {
                    this.eatAnimal(otherAnimal);
                }

            }
        }
    }

    public void eatAnimal(Animal otherAnimal) {
        IslandCell cell = islandCell;
        cell.removeAnimal(otherAnimal);
    }
    public boolean isPredator() {
        return this.category.equals("Predator");
    }

    public boolean isHerbivore() {
        return this.category.equals("Herbivore");
    }
}
