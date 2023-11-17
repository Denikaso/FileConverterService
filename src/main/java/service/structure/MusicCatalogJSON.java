package service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;


public class MusicCatalogJSON {
    @JacksonXmlProperty(localName = "artist")
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
