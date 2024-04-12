package gri.riverjach.videostore;

public class Rental {

    private static final int GRACE = 3;
    private final int days;
    private final VideoType type;

    public Rental(final int days, final String title) {
        this.days = days;
        this.type = VideoRegistry.getType(title);
    }

    public int getPoints() {
        int points = 0;
        if (type == VideoType.REGULAR) {
            points += applyGracePeriod(1, days);
        } else {
            points++;
        }
        return points;
    }

    public int getTotalRental() {
        int totalRental = 0;
        if (type == VideoType.REGULAR) {
            totalRental += applyGracePeriod(150, days);
        } else {
            totalRental += days * 100;
        }
        return totalRental;
    }

    private int applyGracePeriod(int amount, int days) {
        if (days > GRACE) {
            return amount + amount * (days - GRACE);
        }
        return amount;
    }
}
