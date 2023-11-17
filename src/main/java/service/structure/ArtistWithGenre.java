package service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ArtistWithGenre {
    @JsonProperty("name")
    private String name;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("releasedWorks")
    private List<Work> releasedWorks;
    public ArtistWithGenre() {
    }

    public ArtistWithGenre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public List<Work> getReleasedWorks(){return releasedWorks;}
    public void setReleasedWorks(List<Work> releasedWorks){this.releasedWorks = releasedWorks;}
}
