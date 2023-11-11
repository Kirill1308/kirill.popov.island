package entity.map;

import entity.organism.animal.Animal;
import entity.organism.animal.AnimalType;
import entity.organism.plant.Grass;
import entity.organism.plant.Plant;
import properties.FilePropertyReader;
import lombok.Getter;

import java.util.List;
import java.util.Random;

public class Island {
    @Getter
    private final IslandCell[][] cells;
    private final FilePropertyReader filePropertyReader = new FilePropertyReader();

    public Island(int width, int height) {
        cells = new IslandCell[width][height];
        initializeIslandCells();
        loadAnimalProperties();
    }

    private void initializeIslandCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new IslandCell(i, j);
            }
        }
    }

    private void loadAnimalProperties() {
        filePropertyReader.loadAnimalProperties();
    }

    public void populateIsland() {
        Random random = new Random();
        for (IslandCell[] islandCells : cells) {
            for (IslandCell cell : islandCells) {
                addRandomNumOfPlantsToCell(cell);

                int numAnimals = random.nextInt(10);
                for (int k = 0; k < numAnimals; k++) {
                    addRandomAnimalToCell(cell);
                }
            }
        }
    }

    private void addRandomAnimalToCell(IslandCell cell) {
        Random random = new Random();
        AnimalType[] animalTypes = AnimalType.values();
        int randomIndex = random.nextInt(animalTypes.length);
        AnimalType animalType = animalTypes[randomIndex];
        if (canAddAnimal(animalType.getAnimalClass(), cell)) {
            addAnimalToCell(animalType.getAnimalClass(), cell);
        }
    }

    private boolean canAddAnimal(Class<? extends Animal> animalClass, IslandCell cell) {
        int maxQuantity = Integer.parseInt(filePropertyReader.loadMaxQuantity(animalClass.getSimpleName()));
        return countAnimals(animalClass, cell) < maxQuantity;
    }

    private void addAnimalToCell(Class<? extends Animal> animalClass, IslandCell cell) {
        try {
            Animal animal = animalClass.getDeclaredConstructor().newInstance();
            cell.addAnimal(animal);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating an animal instance", e);
        }
    }

    private void addRandomNumOfPlantsToCell(IslandCell cell) {
        Random random = new Random();
        int numOfPlants = random.nextInt(10);
        List<Plant> plants = cell.getPlants();
        for (int i = 0; i < numOfPlants; i++) {
            plants.add(new Grass());
        }
    }

    private int countAnimals(Class<? extends Animal> animalClass, IslandCell cell) {
        int count = 0;
        List<Animal> animals = cell.getAnimals();
        for (Animal animal : animals) {
            if (animalClass.isInstance(animal)) {
                count++;
            }
        }

        return count;
    }

    public IslandCell getTargetCell(int targetX, int targetY) {
        return cells[targetX][targetY];
    }
}
