package com.onebyte.life4cut.user.controller;

import com.onebyte.life4cut.user.controller.dto.UserCreateRequest;
import com.onebyte.life4cut.user.controller.dto.UserCreateResponse;
import com.onebyte.life4cut.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserCreateResponse> create(@Valid @RequestBody UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new UserCreateResponse(userService.createUser(request.getEmail(), request.getNickname(), request.getAddress()))
        );
    }
}
