package printer;

import entity.map.Island;
import entity.map.IslandCell;
import entity.organism.animal.Animal;

import java.util.List;

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
            }
        }
    }

    public static void printIslandContentWithPredators(Island island) {
        IslandCell[][] cells = island.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                List<Animal> animals = cells[i][j].getAnimals();
                boolean hasPredator = false;
                for (Animal animal : animals) {
                    if (animal.isPredator()) {
                        hasPredator = true;
                        break;
                    }
                }
                if (hasPredator) {
                    System.out.println("Cell [" + i + "][" + j + "]:");
                    for (Animal animal : animals) {
                        if (animal.isPredator()) {
                            System.out.println("  - " + animal.getName() + " (" + animal.getCategory() + ")");
                        }
                    }
                }
            }
        }
    }
}
