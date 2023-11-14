package service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class MusicCatalogJSON {
    @JsonProperty("artists")
    private List<ArtistWithGenre> artists;
    public MusicCatalogJSON() {
    }

    public MusicCatalogJSON(List<ArtistWithGenre> artists) {
        this.artists = artists;
    }

    public List<ArtistWithGenre> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistWithGenre> artists) {
        this.artists = artists;
    }
}
