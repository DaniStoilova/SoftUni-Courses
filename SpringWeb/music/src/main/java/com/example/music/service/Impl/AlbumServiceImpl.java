package com.example.music.service.Impl;

import com.example.music.model.binding.AddAlbumBindingModel;
import com.example.music.model.binding.AlbumDTO;
import com.example.music.model.entity.Album;
import com.example.music.model.entity.Artist;
import com.example.music.model.entity.User;
import com.example.music.model.enums.ArtistEnum;
import com.example.music.model.helper.CurrentUser;
import com.example.music.repository.AlbumRepository;
import com.example.music.repository.ArtistRepository;
import com.example.music.repository.UserRepository;
import com.example.music.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private ModelMapper modelMapper;
    
    private AlbumRepository albumRepository;
    
    private ArtistRepository artistRepository;
    
    private UserRepository userRepository;
    
    private CurrentUser currentUser;

    public AlbumServiceImpl(ModelMapper modelMapper, AlbumRepository albumRepository, ArtistRepository artistRepository, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    public void addAlbum(AddAlbumBindingModel addAlbumBindingModel) {
        Artist artist = artistRepository.findByName(addAlbumBindingModel.getArtist());

        User user = userRepository.findByUsername(currentUser.getUsername());

        if (user != null || artist != null){
            Album album = modelMapper.map(addAlbumBindingModel,Album.class);

            album.setArtist(artist);
            album.setAddedFrom(user);

            albumRepository.save(album);


        }

    }

    @Override
    public List<AlbumDTO> getAllCopies() {
        return albumRepository
                .findAllByOrderByCopiesDesc()
                .stream()
                .map(m-> modelMapper.map(m, AlbumDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public BigDecimal getCopies() {
        return albumRepository.getCopies();
    }
}
