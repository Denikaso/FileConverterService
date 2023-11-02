package service;
import service.structure.MusicCatalog;
public interface Writer {
    void write(MusicCatalog musicCatalog, String path);
}
