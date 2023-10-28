package entity.organism.animal;

import abstraction.entity.Eatable;
import abstraction.entity.Movable;
import entity.map.IslandCell;
import entity.organism.Organism;
import properties.FilePropertyReader;

import java.util.List;
public abstract class Animal extends Organism implements Movable, Eatable {
    private final FilePropertyReader filePropertyReader = new FilePropertyReader();
    IslandCell islandCell = new IslandCell();

    public String name;
    public String category;
    private int hunger;

    public Animal(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public int getHunger() {
        return hunger;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public void move() {

    }

    @Override
    public void eat() {
        hunger = filePropertyReader.loadHungerLevel(this.name);
        List<Animal> animalsOnCell = islandCell.getAnimals();

        for (Animal otherAnimal : animalsOnCell) {
            if (otherAnimal != this) {
                if (isPredator() && !otherAnimal.isPredator() /*&& otherAnimal.hunger < this.hunger*/) {
                    eatAnimal(otherAnimal);
                }
            }
        }
        decreaseHungerLevel();
    }

    private void eatAnimal(Animal otherAnimal) {
        islandCell.removeAnimal(otherAnimal);
        decreaseHungerLevel();
    }

    private void decreaseHungerLevel() {
        hunger--;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public boolean isPredator() {
        return this.category.equals("Predator");
    }
}
