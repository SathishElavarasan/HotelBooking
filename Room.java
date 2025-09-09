public class Room {
    protected int roomNo;
    protected String type;
    protected double basePrice;
    protected boolean isBooked;
    protected boolean includeBreakfast;

    public Room(int roomNo, String type, double basePrice) {
        this.roomNo = roomNo;
        this.type = type;
        this.basePrice = basePrice;
        this.isBooked = false;
        this.includeBreakfast = false;
    }

    public boolean checkAvailability() {
        return !isBooked;
    }

    public void book() {
        this.isBooked = true;
    }

    public void book(boolean includeBreakfast) { // Overloaded
        this.isBooked = true;
        this.includeBreakfast = includeBreakfast;
    }

    public void cancel() {
        this.isBooked = false;
        this.includeBreakfast = false;
    }

    public double computeBill() {
        double total = basePrice;
        if (includeBreakfast) total += 20;
        return total;
    }

    // Getters and Setters
    public int getRoomNo() { return roomNo; }
    public String getType() { return type; }
    public boolean isBooked() { return isBooked; }
    public double getBasePrice() { return basePrice; }
}
