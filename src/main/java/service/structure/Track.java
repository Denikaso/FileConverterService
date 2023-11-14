package service.structure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {
    @JacksonXmlProperty(localName = "title")
    private String title;
    @JacksonXmlProperty(localName = "duration")
    private String duration;
    @JacksonXmlProperty(localName = "producer")
    private String producer;
    @JacksonXmlProperty(localName = "featuredArtist")
    @JsonInclude(Include.NON_NULL)
    private String featuredArtist;

    //@JsonInclude(Include.NON_NULL)
    //private String artist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getFeaturedArtist() {
        return featuredArtist;
    }

    public void setFeaturedArtist(String featuredArtist) {
        this.featuredArtist = featuredArtist;
    }
}
