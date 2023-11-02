package service;

import service.structure.MusicCatalog;
public interface Reader {
    MusicCatalog read(String path);
}
