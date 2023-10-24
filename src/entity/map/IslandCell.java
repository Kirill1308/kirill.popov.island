package entity.map;

import entity.organism.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class IslandCell {
    private final List<Animal> animals;

    public IslandCell() {
        animals = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
}
