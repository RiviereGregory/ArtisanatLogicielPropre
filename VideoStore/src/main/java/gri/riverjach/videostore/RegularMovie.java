package gri.riverjach.videostore;

public class RegularMovie extends Movie {

    public RegularMovie() {
        super();
    }

    @Override
    public int getTotalRental(int days) {
        return applyGracePeriod(150, days);
    }

    @Override
    public int getPoints(int days) {
        return applyGracePeriod(1, days);
    }
}
