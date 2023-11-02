package service.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import service.structure.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Json {
    static public void write(MusicCatalog musicCatalog, String jsonFilePath) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.writeValue(new File(jsonFilePath), musicCatalog);
    }
}

