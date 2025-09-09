import java.util.*;

public class BookingService {
    private List<Room> rooms;
    private double dailyRevenue;

    public BookingService() {
        rooms = new ArrayList<>();
        dailyRevenue = 0.0;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void viewAvailableRooms() {
        for (Room room : rooms) {
            if (room.checkAvailability()) {
                System.out.println("Room " + room.getRoomNo() + " (" + room.getType() + ") - $" + room.getBasePrice());
            }
        }
    }

    public boolean bookRoom(int roomNo, boolean includeBreakfast) {
        for (Room room : rooms) {
            if (room.getRoomNo() == roomNo && room.checkAvailability()) {
                room.book(includeBreakfast);
                double bill = room.computeBill();
                dailyRevenue += bill;
                System.out.println("Room booked. Total: $" + bill);
                return true;
            }
        }
        System.out.println("Room not available.");
        return false;
    }

    public boolean cancelBooking(int roomNo) {
        for (Room room : rooms) {
            if (room.getRoomNo() == roomNo && room.isBooked()) {
                room.cancel();
                System.out.println("Booking for Room " + roomNo + " cancelled.");
                return true;
            }
        }
        System.out.println("Booking not found.");
        return false;
    }

    public void generateReport() {
        System.out.println("=== Daily Report ===");
        int occupied = 0;
        for (Room room : rooms) {
            if (room.isBooked()) {
                occupied++;
            }
        }
        System.out.println("Occupied Rooms: " + occupied + "/" + rooms.size());
        System.out.println("Daily Revenue: $" + dailyRevenue);
    }
}
