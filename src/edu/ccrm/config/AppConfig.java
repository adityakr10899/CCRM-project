package edu.ccrm.config;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

// Singleton AppConfig
public final class AppConfig {
    private static AppConfig instance;
    private final Path dataRoot;
    private final Instant startedAt;

    private AppConfig() {
        this.dataRoot = Paths.get(System.getProperty("user.dir"), "data");
        this.startedAt = Instant.now();
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) instance = new AppConfig();
        return instance;
    }

    public Path getDataRoot() { return dataRoot; }
    public Instant getStartedAt() { return startedAt; }
}
