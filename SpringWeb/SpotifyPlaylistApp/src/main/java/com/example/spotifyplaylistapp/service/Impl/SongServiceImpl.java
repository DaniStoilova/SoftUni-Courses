package com.example.spotifyplaylistapp.service.Impl;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.util.CurrentUser;
import com.example.spotifyplaylistapp.model.SongDTO;
import com.example.spotifyplaylistapp.model.binding.SongAddBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.StyleService;
import com.example.spotifyplaylistapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {


   private final SongRepository songRepository;

   private final StyleRepository styleRepository;

   private ModelMapper modelMapper;

   private CurrentUser currentUser;


    private final StyleService styleService;

    private final UserService userService;

    private final UserRepository userRepository;



    public SongServiceImpl(SongRepository songRepository, StyleRepository styleRepository, ModelMapper modelMapper, CurrentUser currentUser, StyleService styleService, UserService userService, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.styleRepository = styleRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.styleService = styleService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void add(SongAddBindingModel songAddBindingModel) {

        Song song = modelMapper.map(songAddBindingModel,Song.class);

        song.setStyle(styleRepository.findByStyleName(songAddBindingModel.getStyle()));

        songRepository.save(song);

    }
    @Override
    public List<SongDTO> findAllSongsByStyleName(StyleEnum styleEnum) {
        return songRepository
                .findAllByStyle_StyleName(styleEnum)
                .stream()
                .map(m->modelMapper.map(m,SongDTO.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<SongDTO> getPlaylist(Long id) {
//        return songRepository.findAllByUserId(id)
//                .stream()
//                .map(m->modelMapper.map(m,SongDTO.class))
//                .collect(Collectors.toList());
//    }

    @Override
    public BigDecimal findTotal() {
        return songRepository.findTotalDuration();

    }




}
