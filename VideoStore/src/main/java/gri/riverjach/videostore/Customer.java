package gri.riverjach.videostore;

import static gri.riverjach.videostore.VideoRegistry.getType;


public class Customer {

    private static final int GRACE = 3;
    private int days;
    private String title;

    public void addRental(String title, int days) {
        this.days = days;
        this.title = title;
    }

    public int getRentalFee() {
        if (getType(title) == VideoType.REGULAR) {
            return applyGracePeriod(150);
        }
        return days * 100;
    }


    public int getRenterPoints() {
        if (getType(title) == VideoType.REGULAR) {
            return applyGracePeriod(1);
        }
        return 1;
    }

    private int applyGracePeriod(int amount) {
        if (days > GRACE) {
            return amount + amount * (days - GRACE);
        }
        return amount;
    }

}
