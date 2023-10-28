package printer;

import entity.map.Island;
import entity.map.IslandCell;
import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Herbivore;
import entity.organism.plant.Plant;

import java.util.List;
import java.util.Random;

public class ConsoleViewProvider {
    public static void printIslandContent(Island island) {
        for (int i = 0; i < island.getCells().length; i++) {
            for (int j = 0; j < island.getCells()[i].length; j++) {
                IslandCell cell = island.getCells()[i][j];
                System.out.println("Cell [" + i + "][" + j + "]:");
                List<Animal> animals = cell.getAnimals();
                for (Animal animal : animals) {
                    System.out.println("  - " + animal.name + " (" + animal.category + ")");
                }

                List<Plant> plants = cell.getPlants();
                for (Plant plant : plants) {
                    System.out.println("  - " + plant.getName());
                }
            }
        }
    }
}
