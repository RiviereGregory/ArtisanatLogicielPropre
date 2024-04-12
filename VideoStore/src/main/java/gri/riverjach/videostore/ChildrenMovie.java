package gri.riverjach.videostore;

public class ChildrenMovie extends Movie {
    public ChildrenMovie() {
        super();
    }

    @Override
    public int getTotalRental(int days) {
        return days * 100;
    }

    @Override
    public int getPoints(int days) {
        return 1;
    }
}
