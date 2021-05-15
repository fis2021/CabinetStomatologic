import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {

        public static String APPLICATION_FOLDER = ".cabinet-stomatologic";
        private static final String USER_FOLDER = System.getProperty("user.home");


        public static Path getPathToFile(String... path) {
            return getAplicationHomeFolder().resolve(Paths.get(".", path));
        }

    @NotNull
    public static Path getAplicationHomeFolder() {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }

    static void initDirectory() {
        Path applicationHomePath = getAplicationHomeFolder();
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

}
