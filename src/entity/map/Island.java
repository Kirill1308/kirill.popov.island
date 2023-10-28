package entity.map;

import entity.organism.animal.Animal;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.predator.Wolf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Island {
    private final IslandCell[][] cells;
    private final List<Class<? extends Animal>> availableAnimalsTypes = new ArrayList<>();

    public Island(int width, int height) {
        cells = new IslandCell[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new IslandCell();
            }
        }
        loadAnimalProperties();
        availableAnimalsTypes.add(Wolf.class);
        availableAnimalsTypes.add(Horse.class);
    }

    public IslandCell[][] getCells() {
        return cells;
    }

    private final Properties animalProperties = new Properties();

    private void loadAnimalProperties() {
        try {
            FileInputStream input = new FileInputStream("./src/properties/animal_properties.properties");
            animalProperties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populateIsland() {
        Random random = new Random();
        for (IslandCell[] islandCells : cells) {
            for (IslandCell cell : islandCells) {

                int numAnimals = random.nextInt(5);
                for (int k = 0; k < numAnimals; k++) {
                    int randomIndex = random.nextInt(availableAnimalsTypes.size());
                    Class<? extends Animal> animalClass = availableAnimalsTypes.get(randomIndex);
                    if (canAddAnimal(animalClass)) {
                        addAnimalToCell(animalClass, cell);
                    }
                }
            }
        }
    }

    private boolean canAddAnimal(Class<? extends Animal> animalClass) {

        int maxQuantity = Integer.parseInt(animalProperties.getProperty(animalClass.getSimpleName() + ".max_quantity", "0"));
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

    public void feedAnimals() {
        for (IslandCell[] islandCells : cells) {
            for (IslandCell cell : islandCells) {
                List<Animal> animalsOnCell = cell.getAnimals();

                for (int i = animalsOnCell.size() - 1; i >= 0; i--) {
                    Animal animal = animalsOnCell.get(i);
                    animal.eat();

                    // Если животное не голодно (hunger == 0), удаляем его из ячейки
                    if (animal.getHunger() == 0) {
                        animalsOnCell.remove(i);
                    }
                }
            }
        }
    }
}
