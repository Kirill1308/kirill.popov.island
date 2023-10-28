import entity.map.Island;
import printer.ConsoleViewProvider;

public class IslandModelApp {
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;

    public static void main(String[] args) {
        Island island = new Island(WIDTH, HEIGHT);
        island.populateIsland();
        ConsoleViewProvider.printIslandContent(island);


        System.out.println("\nPredators ate all the herbivores in their cells!\n");

        island.feedWolves();

        ConsoleViewProvider.printIslandContent(island);

    }
}