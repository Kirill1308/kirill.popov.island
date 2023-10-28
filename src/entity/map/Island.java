package entity.map;

import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.predator.Wolf;
import entity.organism.plant.Cactus;
import entity.organism.plant.Plant;
import lombok.Getter;
import properties.FilePropertyReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Island {
    @Getter
    private final IslandCell[][] cells;
    private final List<Class<? extends Animal>> availableAnimalsTypes = new ArrayList<>();
    private final FilePropertyReader filePropertyReader = new FilePropertyReader();

    public Island(int width, int height) {
        cells = new IslandCell[width][height];
        initializeIslandCells();
        loadAnimalProperties();

        availableAnimalsTypes.add(Wolf.class);
        availableAnimalsTypes.add(Horse.class);
    }

    private void initializeIslandCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new IslandCell();
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

                int numAnimals = random.nextInt(5);
                for (int k = 0; k < numAnimals; k++) {
                    addRandomAnimalToCell(cell);
                }
            }
        }
    }

    private void addRandomAnimalToCell(IslandCell cell) {
        Random random = new Random();
        int randomIndex = random.nextInt(availableAnimalsTypes.size());
        Class<? extends Animal> animalClass = availableAnimalsTypes.get(randomIndex);
        if (canAddAnimal(animalClass)) {
            addAnimalToCell(animalClass, cell);
        }
    }

    private boolean canAddAnimal(Class<? extends Animal> animalClass) {
        int maxQuantity = Integer.parseInt(filePropertyReader.loadMaxQuantity(animalClass.getSimpleName()));
        return countAnimals(animalClass) < maxQuantity;
    }

    private void addAnimalToCell(Class<? extends Animal> animalClass, IslandCell cell) {
        try {
            Animal animal = animalClass.getDeclaredConstructor().newInstance();
            cell.addAnimal(animal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int countAnimals(Class<? extends Animal> animalClass) {
        int count = 0;
        for (IslandCell[] islandCells : cells) {
            for (IslandCell cell : islandCells) {

                List<Animal> animals = cell.getAnimals();
                for (Animal animal : animals) {
                    if (animalClass.isInstance(animal)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void addRandomNumOfPlantsToCell(IslandCell cell) {
        Random random = new Random();
        int numOfPlants = random.nextInt(1, 5);
        List<Plant> plants = cell.getPlants();
        for (int i = 0; i < numOfPlants; i++) {
            plants.add(new Cactus("Cactus"));
        }
    }

    public void feedWolves() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                IslandCell cell = cells[i][j];
                List<Animal> animals = cell.getAnimals();
                List<Animal> herbivores = new ArrayList<>();

                for (Animal animal : animals) {
                    if (animal instanceof Wolf) {
                        // Если это лев, добавляем его в список для питания
                        Wolf wolf = (Wolf) animal;
                        wolf.eat();
                    } else if (animal.isHerbivore()) {
                        // Если это травоядное, добавляем его в список травоядных
                        herbivores.add(animal);
                    }
                }

                // Удаляем травоядных из ячейки после того как их покормили
                for (Animal herbivore : herbivores) {
                    cell.removeAnimal(herbivore);
                }
            }
        }
    }


}
