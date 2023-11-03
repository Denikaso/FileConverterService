package service.structure;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


//@JsonTypeName("Клип")
@JacksonXmlRootElement(localName = "Клип")
public class VideoClip extends Work{
    @JacksonXmlProperty(localName = "viewCount")
    private int viewCount;
    @JacksonXmlProperty(localName = "producer")
    private String producer;
    @JacksonXmlProperty(localName = "editor")
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
