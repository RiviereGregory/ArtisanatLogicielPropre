package gri.riverjach.videostore;

import java.util.ArrayList;
import java.util.List;


public class Customer {

    private static final int GRACE = 3;

    private final List<Rental> rentals = new ArrayList<>();

    public void addRental(String title, int days) {
        rentals.add(new Rental(days, title));
    }

    public int getRentalFee() {
        int totalRental = 0;
        for (Rental rental : rentals) {
            if (rental.getType() == VideoType.REGULAR) {
                totalRental += applyGracePeriod(150, rental.getDays());
            } else {
                totalRental += rental.getDays() * 100;
            }
        }
        return totalRental;
    }


    public int getRenterPoints() {
        int points = 0;
        for (Rental rental : rentals) {
            if (rental.getType() == VideoType.REGULAR) {
                points += applyGracePeriod(1, rental.getDays());
            } else {
                points++;
            }
        }
        return points;
    }

    private int applyGracePeriod(int amount, int days) {
        if (days > GRACE) {
            return amount + amount * (days - GRACE);
        }
        return amount;
    }

}
