package service.structure;

public class Track {
    private String title;
    private String duration;
    private String producer;
    private String featuredArtist;

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
