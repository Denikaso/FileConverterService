package service.structure;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JsonTypeName("Альбом")
public class Album extends Work{
    @JacksonXmlProperty(localName = "listenCount") // Поле "listenCount" в альбоме
    private int listenCount;
    @JacksonXmlElementWrapper(localName = "tracks") // Элемент "tracks" содержит список треков
    @JacksonXmlProperty(localName = "track") // Подэлементы "track"
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
