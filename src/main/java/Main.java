import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import service.structure.*;
import service.converters.Xml;
import service.converters.Json;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import service.*;

public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length != 2)
        {
            throw new Exception();
        }

        Xml xmlConverter = new Xml();

        String inputFilePath = args[0];
        String outputFilePath = args[1];


        if (inputFilePath.endsWith(".xml")) {
            try {
                MusicCatalog musicCatalog = xmlConverter.read(inputFilePath);
                Json.write(musicCatalog, outputFilePath);
                compareFiles(outputFilePath, "data.json");
            }
            catch (IOException e) {
                    e.printStackTrace();
            }

        }
        else if (inputFilePath.endsWith(".json")) {
            try {
                List<ArtistWithGenre> artistsWithGenre = Json.read(inputFilePath);
                xmlConverter.write(artistsWithGenre, outputFilePath);
                compareFiles(outputFilePath, "data.xml");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static void compareFiles(String filePath1, String resourceFilePath2)
            throws IOException, NoSuchAlgorithmException {
        InputStream resourceStream = Main.class.getResourceAsStream(resourceFilePath2);

        File tempFile = File.createTempFile("temp", null);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = resourceStream.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }

        if (FileComparator.compareFiles(filePath1, tempFile.getAbsolutePath())) {
            System.out.println("Исходный и ресурсный файлы идентичны.");
        } else {
            System.out.println("Исходный и ресурсный файлы различны.");
        }
    }
}

