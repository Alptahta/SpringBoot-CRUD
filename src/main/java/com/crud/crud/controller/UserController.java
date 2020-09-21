package com.crud.crud.controller;

import com.crud.crud.domain.User;
import com.crud.crud.service.UserService;
import com.crud.crud.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private String applicationName = "DEMO APP";
    private static final String ENTITY_NAME = "userService";

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        User result = userService.save(user);
        return ResponseEntity.created(new URI("/api/users/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
}
