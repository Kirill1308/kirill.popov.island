package usermanagement;

import java.util.Scanner;

public class UserHandler {
    private final Scanner scanner = new Scanner(System.in);
    public int width;
    public int height;

    public void readCoordinates() {
        width = readCoordinate("WIDTH of your Island");
        height = readCoordinate("HEIGHT of your Island");
    }

    private int readCoordinate(String coordinateName) {
        int coordinate = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Input " + coordinateName + ": ");
            if (scanner.hasNextInt()) {
                coordinate = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        return coordinate;
    }
}

