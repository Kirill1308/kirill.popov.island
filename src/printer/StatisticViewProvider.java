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
        printAllOrganismCounts(animals, plants);
    }

    private void printAllOrganismCounts(List<Animal> animals, List<Plant> plants) {
        printOrganismCountAndEmoji(animals, Wolf.class);
        printOrganismCountAndEmoji(animals, Bear.class);
        printOrganismCountAndEmoji(animals, Rabbit.class);
        printOrganismCountAndEmoji(animals, Horse.class);
        printOrganismCountAndEmoji(plants, Grass.class);
    }

    private void printOrganismCountAndEmoji(List<? extends Organism> organisms, Class<? extends Organism> organismType) {
        long count = countEntitiesOfType(organisms, organismType);
        String emoji = propertyReader.loadIcon(organismType.getSimpleName());
        System.out.printf("%s(%d)\t", emoji, count);
    }

    private long countEntitiesOfType(List<? extends Organism> entities, Class<? extends Organism> entityType) {
        return entities.stream().filter(entityType::isInstance).count();
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
        System.out.println("Current organisms in cell [" + islandCell.getX() + "][" + islandCell.getY() + "]:");

        printOrganismsDetails(plants);
        printOrganismsDetails(animals);
    }

    private void printOrganismsDetails(List<? extends Organism> organisms) {
        for (Organism organism : organisms) {
            String details = organism.getIcon() + " id = " + organism.getId();
            System.out.println(details);
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

    public int countAnimalsOfType(List<Animal> animals, Class<? extends Animal> animalType) {
        return countOrganismsOfType(animals, animalType);
    }

    private int countOrganismsOfType(List<? extends Organism> entities, Class<? extends Organism> entityType) {
        return (int) entities.stream().filter(entityType::isInstance).count();
    }

}
