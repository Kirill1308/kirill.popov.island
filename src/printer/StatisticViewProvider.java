package printer;

import entity.map.IslandCell;
import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.herbivore.Rabbit;
import entity.organism.animal.predator.Bear;
import entity.organism.animal.predator.Wolf;
import entity.organism.plant.Grass;
import entity.organism.plant.Plant;

import java.util.List;

public class StatisticViewProvider {

    public synchronized void printStatistic(List<Animal> animals, List<Plant> plants, IslandCell islandCell) {
        System.out.print("(" + islandCell.getX() + ", " + islandCell.getY() + ")\t");

        int numWolves = countAnimalsOfType(animals, Wolf.class);
        int numBears = countAnimalsOfType(animals, Bear.class);
        int numRabbits = countAnimalsOfType(animals, Rabbit.class);
        int numHorses = countAnimalsOfType(animals, Horse.class);
        int numPlants = countPlantsOfType(plants, Grass.class);

        System.out.print("🐺 " + "(" + numWolves + ")" + "\t");
        System.out.print("🐻" + "(" + numBears + ")" + "\t");
        System.out.print("🐰" + "(" + numRabbits + ")" + "\t");
        System.out.print("🐴" + "(" + numHorses + ")" + "\t");
        System.out.print("🌱" + "(" + numPlants + ")" + "\t");
    }

    public void printAnimalNames(List<Animal> animals, List<Plant> plants, IslandCell islandCell) {
        System.out.println("=".repeat(45));
        System.out.println("Current animals in cell [" + islandCell.getX() + "][" + islandCell.getY() + "]" + ":");
        for (Plant plant : plants) {
            System.out.println(plant.getIcon() + " id = " + plant.getId());
        }
        for (Animal animal : animals) {
            System.out.println(animal.getIcon() + " id = " + animal.getId());
        }
    }

    public void printCellStatistics(IslandCell[][] cells) {
        for (IslandCell[] cell : cells) {
            for (IslandCell islandCell : cell) {
                List<Animal> animals = islandCell.getAnimals();
                List<Plant> plants = islandCell.getPlants();
                printStatistic(animals, plants, islandCell);
                System.out.println();
            }
        }
    }

    private int countPlantsOfType(List<Plant> plants, Class<? extends Plant> plantType) {
        int count = 0;
        for (Plant plant : plants) {
            if (plantType.isInstance(plant)) {
                count++;
            }
        }
        return count;
    }

    public int countAnimalsOfType(List<Animal> animals, Class<? extends Animal> animalType) {
        int count = 0;
        for (Animal animal : animals) {
            if (animalType.isInstance(animal)) {
                count++;
            }
        }
        return count;
    }
}
