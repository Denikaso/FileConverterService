package service.structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "musicCatalog")
public class MusicCatalog {
    private List<Genre> genres;

    private List<PersonalPlaylist> personalPlaylists;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<PersonalPlaylist> getPersonalPlaylists() {
        return personalPlaylists;
    }

    public void setPersonalPlaylists(List<PersonalPlaylist> personalPlaylists) {
        this.personalPlaylists = personalPlaylists;
    }
}
