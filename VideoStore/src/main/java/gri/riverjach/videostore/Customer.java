package gri.riverjach.videostore;

import java.util.ArrayList;
import java.util.List;


public class Customer {


    private final List<Rental> rentals = new ArrayList<>();

    public void addRental(String title, int days) {
        rentals.add(new Rental(days, title));
    }

    public int getRentalFee() {
        int totalRental = 0;
        for (Rental rental : rentals) {
            totalRental += rental.getTotalRental();
        }
        return totalRental;
    }


    public int getRenterPoints() {
        int points = 0;
        for (Rental rental : rentals) {
            points += rental.getPoints();
        }
        return points;
    }


}
