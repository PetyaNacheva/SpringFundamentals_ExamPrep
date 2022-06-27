package musicdb.service.Impl;

import musicdb.model.AlbumEntity;
import musicdb.model.ArtistEntity;
import musicdb.model.UserEntity;
import musicdb.model.service.AlbumServiceModel;
import musicdb.model.view.AlbumViewModel;
import musicdb.repository.AlbumRepository;
import musicdb.service.AlbumService;
import musicdb.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;


    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel, UserEntity user) {

        AlbumEntity album =modelMapper.map(albumServiceModel, AlbumEntity.class);
        album.setAddedFrom(user);
        ArtistEntity name = artistService.findByName(albumServiceModel.getArtist());
        album.setArtist(name);
        album.setGenre(albumServiceModel.getGenre());
        albumRepository.save(album);
    }

    @Override
    public List<AlbumViewModel> getAllAlbums() {
        return albumRepository.findAll().stream().map(album->{
            AlbumViewModel viewModel = modelMapper.map(album, AlbumViewModel.class);
            viewModel.setArtist(album.getArtist().getName().name());
            return viewModel;
        }).collect(Collectors.toList());

    }

    @Override
    public BigInteger getAllCopies() {
        if(albumRepository.findTotalSoldCopies()==null){
            return BigInteger.valueOf(0);
        }else{
           return albumRepository.findTotalSoldCopies();
        }
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
