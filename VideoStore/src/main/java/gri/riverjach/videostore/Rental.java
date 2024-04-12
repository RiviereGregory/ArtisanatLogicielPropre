package gri.riverjach.videostore;

public class Rental {

    private final int days;
    private final Movie movie;

    public Rental(final int days, final String title) {
        this.days = days;
        this.movie = VideoRegistry.getMovie(title);
    }

    public int getPoints() {
        return movie.getPoints(days);
    }

    public int getTotalRental() {
        return movie.getTotalRental(days);
    }
}
