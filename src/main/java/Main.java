import java.io.IOException;

import service.structure.*;
import service.converters.Xml;
import service.converters.Json;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length != 2)
        {
            throw new Exception();
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];


        if (inputFilePath.endsWith(".xml")) {
            try {
                MusicCatalog musicCatalog = Xml.read(inputFilePath);
                Json.write(musicCatalog, outputFilePath);
            }
            catch (IOException e) {
                    e.printStackTrace();
                }

        }
        else if (inputFilePath.endsWith(".json")) {
            try {
                List<ArtistWithGenre> artistsWithGenre = Json.read(inputFilePath);
                Xml.write(artistsWithGenre, outputFilePath);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

