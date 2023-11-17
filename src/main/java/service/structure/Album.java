package service.structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

public class Album{
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
