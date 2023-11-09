import java.io.IOException;

import service.structure.*;
import service.converters.Xml;
import service.converters.Json;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Уник\\Практика3\\test\\data.xml";
        String outputFilePath = "C:\\Уник\\Практика3\\test\\data.json";

        String format = "xmltojson";

        if (format.equals("xmltojson")) {
            try {
                MusicCatalog musicCatalog = Xml.read(inputFilePath);
                Json.write(musicCatalog, outputFilePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }

        } else if (format.equals("jsontoxml")) {
        } else {
            System.err.println("Invalid format. Use 'xmltojson' or 'jsontoxml'.");
            System.exit(1);
        }
    }
}

