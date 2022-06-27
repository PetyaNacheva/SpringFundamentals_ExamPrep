package musicdb.service;

import musicdb.model.UserEntity;
import musicdb.model.service.AlbumServiceModel;
import musicdb.model.view.AlbumViewModel;

import java.math.BigInteger;
import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumServiceModel albumServiceModel, UserEntity user);

    List<AlbumViewModel> getAllAlbums();
    BigInteger getAllCopies();

    void deleteAlbum(Long id);
}
