package service.converters;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import service.structure.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Xml {
    private XmlMapper xmlMapper;

    public Xml() {
        this.xmlMapper = new XmlMapper();
    }
    final public MusicCatalog read(String xmlFilePath) throws IOException {
        return xmlMapper.readValue(new File(xmlFilePath), MusicCatalog.class);
    }
    final public void write(List<ArtistWithGenre> artistsWithGenre, String xmlFilePath) throws IOException {
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        MusicCatalog musicCatalog = new MusicCatalog();

        for (ArtistWithGenre artistWithGenre : artistsWithGenre) {
            Genre genre = musicCatalog.getGenres().stream()
                    .filter(existingGenre -> existingGenre.getName().equals(artistWithGenre.getGenre()))
                    .findFirst()
                    .orElseGet(() -> {
                        Genre newGenre = new Genre();
                        newGenre.setName(artistWithGenre.getGenre());
                        newGenre.setArtists(new ArrayList<>());
                        musicCatalog.getGenres().add(newGenre);
                        return newGenre;
                    });

            Artist artist = new Artist();
            artist.setName(artistWithGenre.getName());
            artist.setReleasedWorks(artistWithGenre.getReleasedWorks());
            genre.getArtists().add(artist);
        }

        try (OutputStream os = Files.newOutputStream(new File(xmlFilePath).toPath(), StandardOpenOption.WRITE)) {
            os.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            xmlMapper.writeValue(os, musicCatalog);
        }
    }
}


