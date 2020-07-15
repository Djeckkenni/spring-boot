package springboot.amazonreviews.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFileWithReviews {
    public static List<String> readFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("File not found! " + e);
        } catch (IOException e) {
            System.out.println("Can't read file! " + e);
        }
        return null;
    }

    public static Path downloadFile(String sourceUrl, String targetDirectory) {
        URL url = null;
        try {
            url = new URL(sourceUrl);
            String fileName = sourceUrl.substring(sourceUrl.lastIndexOf('/') + 1);
            Path targetPath = new File(targetDirectory + File.separator + fileName).toPath();
            Files.copy(url.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            return targetPath;
        } catch (IOException e) {
            System.out.println("File not found! " + e);
        }
        return null;
    }
}
