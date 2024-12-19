import java.util.Scanner;

public class RoomCodeParser {

    // Class constants
    private static final int CODE_LENGTH = 5;
    private static final int MIN_CODE = 10000; // Minimum 5-digit number is 10000
    private static final int MAX_CODE = 99999; // Maximum 5-digit number is 99999

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int code = (int) getValidatedInput(scanner,
                "Enter the 5-digit room code: ",
                MIN_CODE,
                MAX_CODE,
                "Code must be a 5-digit number between " + MIN_CODE + " and " + MAX_CODE + ".");
        scanner.close();

        processAndDisplayResults(code);
    }

    /**
     * Validates user input ensuring it is within the specified range.
     *
     * @param scanner      The scanner object used for reading input.
     * @param prompt       The message to display to the user.
     * @param minValue     The minimum acceptable value for the input.
     * @param maxValue     The maximum acceptable value for the input.
     * @param errorMessage The error message displayed when invalid input is given.
     * @return The validated numeric input.
     */
    private static double getValidatedInput(Scanner scanner, String prompt, double minValue, double maxValue, String errorMessage) {
        double inputValue;

        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                inputValue = scanner.nextDouble();
                if (inputValue >= minValue && inputValue <= maxValue) {
                    return inputValue; // Valid input
                } else {
                    System.out.println(errorMessage);
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next();
            }
        }
    }

    /**
     * Processes the input code to determine building number, floor number, and room number.
     * Displays the results to the user.
     *
     * @param code The full 5-digit code.
     */
    private static void processAndDisplayResults(int code) {
        int building = calculateBuilding(code);
        int floor = calculateFloor(code);
        int room = calculateRoom(code);

        displayResults(building, floor, room);
    }

    /**
     * Extracts the building number from the code (first two digits).
     *
     * @param code The full 5-digit code.
     * @return The building number.
     */
    private static int calculateBuilding(int code) {
        return code / 1000;
    }

    /**
     * Extracts the floor number from the code (the 3rd digit).
     *
     * @param code The full 5-digit code.
     * @return The floor number.
     */
    private static int calculateFloor(int code) {
        int remainder = code % 1000;
        return remainder / 100;
    }

    /**
     * Extracts the room number from the code (last two digits).
     *
     * @param code The full 5-digit code.
     * @return The room number.
     */
    private static int calculateRoom(int code) {
        return code % 100;
    }

    /**
     * Displays the building, floor, and room information.
     *
     * @param building The building number.
     * @param floor    The floor number.
     * @param room     The room number.
     */
    private static void displayResults(int building, int floor, int room) {
        System.out.println("The student is learning in building number " + building);
        System.out.println("on the floor " + floor);
        System.out.println("in the room number " + room);
    }
}