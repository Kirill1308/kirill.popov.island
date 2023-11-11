package runner;

import entity.map.Island;
import entity.map.IslandCell;
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

        Thread[][] threads = new Thread[cells.length][cells[0].length];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                final int finalI = i;
                final int finalJ = j;
                threads[i][j] = new Thread(() -> simulator.startSimulation(cells[finalI][finalJ], island));
                threads[i][j].start();
            }
        }

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                try {
                    threads[i][j].join();
                } catch (Exception e) {
                    throw new RuntimeException("Thread interrupted while waiting for completion: ", e);
                }
            }
        }

        System.out.println("=".repeat(45));
        System.out.println("Finish!");
        System.out.println("=".repeat(45));
        provider.printCellStatistics(cells);
        System.out.println("=".repeat(45));
    }
}
