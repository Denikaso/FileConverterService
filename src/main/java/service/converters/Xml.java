package service.converters;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import service.structure.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Xml {
    static public MusicCatalog read(String xmlFilePath) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(new File(xmlFilePath), MusicCatalog.class);
    }
}


