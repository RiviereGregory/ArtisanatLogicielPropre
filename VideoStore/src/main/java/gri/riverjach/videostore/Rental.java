package gri.riverjach.videostore;

public class Rental {
    private final int days;
    private final VideoType type;

    public Rental(final int days, final String title) {
        this.days = days;
        this.type = VideoRegistry.getType(title);
    }

    public int getDays() {
        return days;
    }


    public VideoType getType() {
        return type;
    }
}
