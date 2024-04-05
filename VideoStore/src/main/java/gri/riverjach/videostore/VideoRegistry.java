package gri.riverjach.videostore;

import java.util.HashMap;
import java.util.Map;

public class VideoRegistry {

    private static final Map<String, VideoType> movieRegistry = new HashMap<>();

    private VideoRegistry() {
        throw new IllegalStateException("Utility class");
    }

    public static VideoType getType(String title) {
        return movieRegistry.get(title);
    }

    public static void addMovie(String title, VideoType type) {
        movieRegistry.put(title, type);
    }
}
