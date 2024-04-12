package gri.riverjach.videostore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VideoRegistry {

    private static final Map<String, VideoType> movieRegistry = new HashMap<>();

    private VideoRegistry() {
        throw new IllegalStateException("Utility class");
    }

    public static Movie getMovie(String title) {
        VideoType videoType = movieRegistry.get(title);
        if (Objects.requireNonNull(videoType) == VideoType.REGULAR) {
            return new RegularMovie();
        } else if (videoType == VideoType.CHILDREN) {
            return new ChildrenMovie();
        }
        return null;
    }

    public static void addMovie(String title, VideoType type) {
        movieRegistry.put(title, type);
    }
}
