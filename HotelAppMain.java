import java.util.Scanner;

public class HotelAppMain {
    public static void main(String[] args) {
        BookingService service = new BookingService();

        // Add some rooms
        service.addRoom(new Room(101, "Standard", 100));
        service.addRoom(new DeluxeRoom(201));
        service.addRoom(new SuiteRoom(301));
        service.addRoom(new DeluxeRoom(202));
        service.addRoom(new SuiteRoom(302));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Hotel Booking System ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Daily Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.viewAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter Room No to book: ");
                    int roomNo = sc.nextInt();
                    System.out.print("Include breakfast? (true/false): ");
                    boolean breakfast = sc.nextBoolean();
                    service.bookRoom(roomNo, breakfast);
                    break;
                case 3:
                    System.out.print("Enter Room No to cancel: ");
                    int cancelNo = sc.nextInt();
                    service.cancelBooking(cancelNo);
                    break;
                case 4:
                    service.generateReport();
                    break;
                case 5:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
