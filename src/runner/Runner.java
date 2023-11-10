package runner;

import entity.map.Island;
import entity.map.IslandCell;
import entity.organism.animal.predator.Wolf;
import printer.StatisticViewProvider;
import simulator.AnimalSimulator;
import usermanagement.UserHandler;

public class Runner {
    private final UserHandler userHandler = new UserHandler();
    private final StatisticViewProvider provider = new StatisticViewProvider();
    private final AnimalSimulator simulator = new AnimalSimulator();

    public void run() {
        userHandler.readCoordinates();
        Island island = new Island(userHandler.width, userHandler.height);
        island.populateIsland();

        System.out.println("=".repeat(45));
        System.out.println("Island is populated!");
        System.out.println("=".repeat(45));

        IslandCell[][] cells = island.getCells();
        provider.printCellStatistics(cells);


        for (IslandCell[] cell : cells) {
            for (IslandCell islandCell : cell) {
                simulator.simulate(islandCell, island);
            }
        }

        System.out.println("=".repeat(45));
        System.out.println("Finish!");
        System.out.println("=".repeat(45));
        provider.printCellStatistics(cells);
        System.out.println("=".repeat(45));
    }
}
