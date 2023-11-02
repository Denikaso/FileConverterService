package service.structure;

import java.util.List;

public class Artist {
    private String name;
    private List<Work> releasedWorks;

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
