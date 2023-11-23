package service.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import service.structure.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Json {
    private ObjectMapper jsonMapper;

    public Json() {
        this.jsonMapper = new ObjectMapper();
        this.jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    final public void write(MusicCatalog musicCatalog, String jsonFilePath) throws IOException {
        List<ArtistWithGenre> artistsWithGenreList = musicCatalog.getGenres().stream()
                .flatMap(genre -> genre.getArtists().stream()
                        .collect(Collectors.toMap(
                                Artist::getName,
                                artist -> {
                                    ArtistWithGenre artistWithGenre = new ArtistWithGenre(artist.getName());
                                    artistWithGenre.setGenre(genre.getName());
                                    artistWithGenre.setReleasedWorks(artist.getReleasedWorks());
                                    return artistWithGenre;
                                },
                                (existing, replacement) -> existing
                        ))
                        .values().stream()
                )
                .toList();

        MusicCatalogJSON musicCatalogJSON = new MusicCatalogJSON(artistsWithGenreList);
        jsonMapper.writeValue(new File(jsonFilePath), musicCatalogJSON);
    }
     final public List<ArtistWithGenre> read(String jsonFilePath) throws IOException {
        MusicCatalogJSON musicCatalogJSON = jsonMapper.readValue(new File(jsonFilePath), MusicCatalogJSON.class);
        return musicCatalogJSON.getArtists();
    }
}
