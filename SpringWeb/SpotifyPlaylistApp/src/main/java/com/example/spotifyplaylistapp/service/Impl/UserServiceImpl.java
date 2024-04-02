package com.example.spotifyplaylistapp.service.Impl;

import com.example.spotifyplaylistapp.util.CurrentUser;
import com.example.spotifyplaylistapp.model.binding.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.binding.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final SongRepository songRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    private final CurrentUser currentUser;


    public UserServiceImpl(UserRepository userRepository, SongRepository songRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;

    }


    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {

        User user = modelMapper.map(userRegisterBindingModel, User.class);

        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);

    }

    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }

        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public void login(UserLoginBindingModel userLoginBindingModel) {

        User user = userRepository.findByUsername(userLoginBindingModel.getUsername());

        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());


    }

    @Override
    public void addToPlaylist(Long id) {
        Optional<Song> byId = this.songRepository.findById(id);

        if (byId.isPresent()){
            User user = userRepository.findByUsername(currentUser.getUsername());
            Song song = byId.get();
            user.addSong(song);
            userRepository.save(user);

        }
    }

    @Override
    public List<Song> getUserSongs() {
        User user = userRepository.findByUsername(currentUser.getUsername());
        return user.getPlaylist();


    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void removeAll() {

        Optional<User> byUser = userRepository.findById(currentUser.getId());
        if (byUser.isPresent()){
            User user = byUser.get();
            user.delete();
            userRepository.save(user);
        }

    }
}

