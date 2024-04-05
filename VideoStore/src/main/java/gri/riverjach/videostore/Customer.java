package gri.riverjach.videostore;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private int days;
    private String title;
    private final Map<String, VideoType> movieRegistry = new HashMap<>();

    public Customer() {
        movieRegistry.put("RegularMovie", VideoType.REGULAR);
        movieRegistry.put("ChildrenMovie", VideoType.CHILDREN);
    }

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

    private VideoType getType(String title) {
        return movieRegistry.get(title);
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
