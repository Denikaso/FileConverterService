package service.structure;

import java.util.List;

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
