package musicdb.service;

import musicdb.model.ArtistEntity;
import musicdb.model.enums.ArtistEnum;

public interface ArtistService {
    void initArtist();

    ArtistEntity findByName(ArtistEnum artist);
}
