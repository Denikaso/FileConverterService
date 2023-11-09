package service.structure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JsonTypeName("Альбом")
@JacksonXmlRootElement(localName = "Альбом")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album extends Work{
    @JacksonXmlProperty(localName = "listenCount", isAttribute = true)
    private int listenCount;
    @JacksonXmlElementWrapper(localName = "tracks")
    @JacksonXmlProperty(localName = "track")
    private List<Track> tracks;

    public int getListenCount() {
        return listenCount;
    }

    public void setListenCount(int listenCount) {
        this.listenCount = listenCount;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
