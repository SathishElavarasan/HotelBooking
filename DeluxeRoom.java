public class DeluxeRoom extends Room {
    private boolean hasMiniBar;
    private boolean hasBalcony;

    public DeluxeRoom(int roomNo) {
        super(roomNo, "Deluxe", 150);
        this.hasMiniBar = true;
        this.hasBalcony = true;
    }

    @Override
    public double computeBill() {
        double total = basePrice;
        if (includeBreakfast) total += 20;
        if (hasMiniBar) total += 30;
        return total;
    }

    // Additional Getters/Setters if needed
}
