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
    static public MusicCatalog read(String xmlFilePath) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(new File(xmlFilePath), MusicCatalog.class);
    }
    static public void write(List<ArtistWithGenre> artistsWithGenre, String xmlFilePath) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        MusicCatalog musicCatalog = new MusicCatalog();
        musicCatalog.setGenres(convertToGenreList(artistsWithGenre));
        File tempFile = File.createTempFile("tempfile", ".xml");
        try (OutputStream os = Files.newOutputStream(tempFile.toPath(), StandardOpenOption.WRITE)) {
            os.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            xmlMapper.writeValue(os, musicCatalog);
        }
        Files.move(tempFile.toPath(), new File(xmlFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static List<Genre> convertToGenreList(List<ArtistWithGenre> artistsWithGenre) {
        List<Genre> genres = new ArrayList<>();

        for (ArtistWithGenre artistWithGenre : artistsWithGenre) {
            Genre genre = null;
            for (Genre existingGenre : genres) {
                if (existingGenre.getName().equals(artistWithGenre.getGenre())) {
                    genre = existingGenre;
                    break;
                }
            }
            if (genre == null) {
                genre = new Genre();
                genre.setName(artistWithGenre.getGenre());
                genre.setArtists(new ArrayList<>());
                genres.add(genre);
            }

            Artist artist = new Artist();
            artist.setName(artistWithGenre.getName());
            artist.setReleasedWorks(artistWithGenre.getReleasedWorks());
            genre.getArtists().add(artist);
        }

        return genres;
    }
}


