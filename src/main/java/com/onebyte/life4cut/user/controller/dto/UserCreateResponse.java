package com.onebyte.life4cut.user.controller.dto;

public class UserCreateResponse {

    private Long id;

    public UserCreateResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
