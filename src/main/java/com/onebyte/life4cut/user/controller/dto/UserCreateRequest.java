package com.onebyte.life4cut.user.controller.dto;


import com.onebyte.life4cut.common.vo.Address;
import com.onebyte.life4cut.common.vo.Email;
import com.onebyte.life4cut.common.vo.Zipcode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserCreateRequest {

    @NotBlank
    @Size(max = 20)
    private String nickname;

    @NotBlank
    private String email;

    public Email getEmail() {
        return Email.of(email);
    }

    public String getNickname() {
        return nickname;
    }
}
