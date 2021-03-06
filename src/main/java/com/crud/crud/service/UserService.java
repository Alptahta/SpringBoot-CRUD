package com.crud.crud.service;

import com.crud.crud.domain.User;
import com.crud.crud.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        /*log.debug("Request to save User : {}", user);*/
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        /*log.debug("Request to get all User");*/
        return userRepository.findAll(pageable);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id){
        return userRepository.findById(id);

    }




}
