package entity.map;

import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Horse;
import entity.organism.plant.Plant;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class IslandCell {
    private final List<Animal> animals;
    private final List<Plant> plants;

    public IslandCell() {
        animals = new ArrayList<>();
        plants = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public List<Animal> getHerbivores() {
        List<Animal> herbivores = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Horse) {
                herbivores.add(animal);
            }
        }
        return herbivores;
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }
}
