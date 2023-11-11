package printer;

import entity.map.IslandCell;
import entity.organism.Organism;
import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.herbivore.Rabbit;
import entity.organism.animal.predator.Bear;
import entity.organism.animal.predator.Wolf;
import entity.organism.plant.Grass;
import entity.organism.plant.Plant;
import properties.FilePropertyReader;

import java.util.List;

public class StatisticViewProvider {
    private final FilePropertyReader propertyReader = new FilePropertyReader();

    public synchronized void printCellCoordinatesAndOrganismCounts(List<Animal> animals, List<Plant> plants, IslandCell islandCell) {
        System.out.printf("(%d, %d)\t", islandCell.getX(), islandCell.getY());

        printOrganismCount(animals, Wolf.class);
        printOrganismCount(animals, Bear.class);
        printOrganismCount(animals, Rabbit.class);
        printOrganismCount(animals, Horse.class);
        printOrganismCount(plants, Grass.class);
    }

    private void printOrganismCount(List<? extends Organism> entities, Class<? extends Organism> entityType) {
        int count = countOrganismsOfType(entities, entityType);
        String emoji = propertyReader.loadIcon(entityType.getSimpleName());
        printCountAndEmoji(count, emoji);
    }

    private void printCountAndEmoji(int count, String emoji) {
        System.out.print(emoji + "(" + count + ")" + "\t");
    }


    public void printAnimalAndPlantDetails(List<Animal> animals, List<Plant> plants, IslandCell islandCell) {
        System.out.println("=".repeat(45));
        System.out.println("Current organisms in cell [" + islandCell.getX() + "][" + islandCell.getY() + "]" + ":");
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
                printCellCoordinatesAndOrganismCounts(animals, plants, islandCell);
                System.out.println();
            }
        }
    }

    private int countOrganismsOfType(List<? extends Organism> entities, Class<? extends Organism> entityType) {
        int count = 0;
        for (Organism entity : entities) {
            if (entityType.isInstance(entity)) {
                count++;
            }
        }
        return count;
    }

    public int countAnimalsOfType(List<Animal> animals, Class<? extends Animal> animalType) {
        return countOrganismsOfType(animals, animalType);
    }

}
