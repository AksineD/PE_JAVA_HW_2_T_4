import java.util.Scanner;

public class RoomCodeParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the 5-digit room code: ");
        int code = sc.nextInt();
        sc.close();

        // Extract parts of the code
        int building = code / 1000;            // First two digits
        int remainder = code % 1000;           // Last three digits
        int floor = remainder / 100;           // The third digit
        int room = remainder % 100;            // Last two digits

        System.out.println("The student is learning in building number " + building);
        System.out.println("on the floor " + floor);
        System.out.println("in the room number " + room);
    }
}
