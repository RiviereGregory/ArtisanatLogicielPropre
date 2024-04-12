package gri.riverjach.videostore;

public abstract class Movie {
    private static final int GRACE = 3;

    protected Movie() {
    }


    public abstract int getTotalRental(int days);

    public abstract int getPoints(int days);

    protected int applyGracePeriod(int amount, int days) {
        if (days > GRACE) {
            return amount + amount * (days - GRACE);
        }
        return amount;
    }
}
