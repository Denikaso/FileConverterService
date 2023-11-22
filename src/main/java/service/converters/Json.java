package service.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import service.structure.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Json {
    static final public void write(MusicCatalog musicCatalog, String jsonFilePath) throws IOException {
        List<ArtistWithGenre> artistsWithGenreList = new ArrayList<>();

        for (Genre genre : musicCatalog.getGenres()) {
            for (Artist artist : genre.getArtists()) {
                ArtistWithGenre artistWithGenre = null;

                for (ArtistWithGenre existingArtist : artistsWithGenreList) {
                    if (existingArtist.getName().equals(artist.getName())) {
                        artistWithGenre = existingArtist;
                        break;
                    }
                }

                if (artistWithGenre == null) {
                    artistWithGenre = new ArtistWithGenre(artist.getName());
                    artistWithGenre.setGenre(genre.getName());
                    artistWithGenre.setReleasedWorks(artist.getReleasedWorks());
                    artistsWithGenreList.add(artistWithGenre);
                }
            }
        }

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);

        MusicCatalogJSON musicCatalogJSON = new MusicCatalogJSON(artistsWithGenreList);
        jsonMapper.writeValue(new File(jsonFilePath), musicCatalogJSON);
    }
    static final public List<ArtistWithGenre> read(String jsonFilePath) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        MusicCatalogJSON musicCatalogJSON = jsonMapper.readValue(new File(jsonFilePath), MusicCatalogJSON.class);
        return musicCatalogJSON.getArtists();
    }
}
