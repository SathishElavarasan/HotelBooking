public class SuiteRoom extends Room {
    private boolean hasJacuzzi;
    private boolean hasLivingRoom;

    public SuiteRoom(int roomNo) {
        super(roomNo, "Suite", 250);
        this.hasJacuzzi = true;
        this.hasLivingRoom = true;
    }

    @Override
    public double computeBill() {
        double total = basePrice;
        if (includeBreakfast) total += 25;
        if (hasJacuzzi) total += 50;
        if (hasLivingRoom) total += 40;
        return total;
    }

    // Additional Getters/Setters if needed
}
