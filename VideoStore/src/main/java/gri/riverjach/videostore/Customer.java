package gri.riverjach.videostore;

import static gri.riverjach.videostore.VideoRegistry.getType;


public class Customer {

    private int days;
    private String title;

    public void addRental(String title, int days) {
        this.days = days;
        this.title = title;
    }

    public int getRentalFee() {
        if (getType(title) == VideoType.REGULAR) {
            return applyGracePeriod(150, 3);
        }
        return 100;
    }


    public int getRenterPoints() {
        return applyGracePeriod(1, 3);
    }

    private int applyGracePeriod(int amount, int grace) {
        if (days > grace) {
            return amount + amount * (days - grace);
        }
        return amount;
    }

}
