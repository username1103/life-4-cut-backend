package com.onebyte.life4cut.user.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchUserDto {
    private Long id;
    private String nickname;
    private String email;
}
