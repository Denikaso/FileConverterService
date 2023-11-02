package service.structure;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonTypeName("Клип")
public class VideoClip extends Work{
    @JacksonXmlProperty(localName = "viewCount") // Поле "viewCount" в клипе
    private int viewCount;
    @JacksonXmlProperty(localName = "producer") // Поле "producer" в клипе
    private String producer;
    @JacksonXmlProperty(localName = "editor") // Поле "editor" в клипе
    private String editor;

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}
