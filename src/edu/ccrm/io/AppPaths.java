package edu.ccrm.io;
import edu.ccrm.config.AppConfig;
import java.nio.file.Path;
public class AppPaths {
    public static Path getDataRoot(){
        return AppConfig.getInstance().getDataRoot();
    }
}
