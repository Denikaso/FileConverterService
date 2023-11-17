package service.structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Artist {
    @JacksonXmlProperty(localName ="name", isAttribute = true)
    private String name;
    @JacksonXmlElementWrapper(localName = "releasedWorks")
    @JacksonXmlProperty(localName = "work")
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
