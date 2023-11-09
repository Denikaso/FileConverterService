package service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GenreWithReleasedWorks {
    @JsonProperty("name")
    private String name;

    @JsonProperty("releasedWorks")
    private List<Work> releasedWorks;

    public GenreWithReleasedWorks(String name, List<Work> releasedWorks) {
        this.name = name;
        this.releasedWorks = releasedWorks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Work> getReleasedWorks() {
        return releasedWorks;
    }

    public void setReleasedWorks(List<Work> releasedWorks) {
        this.releasedWorks = releasedWorks;
    }
}
