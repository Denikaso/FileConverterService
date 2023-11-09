package service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ArtistWithGenre {
    @JsonProperty("name")
    private String name;

    @JsonProperty("genres")
    private List<GenreWithReleasedWorks> genres = new ArrayList<>();

    public ArtistWithGenre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GenreWithReleasedWorks> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreWithReleasedWorks> genres) {
        this.genres = genres;
    }

    public void addGenreWithReleasedWorks(GenreWithReleasedWorks genreWithReleasedWorks) {
        genres.add(genreWithReleasedWorks);
    }
}
