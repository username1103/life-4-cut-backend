package com.onebyte.life4cut.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onebyte.life4cut.user.controller.dto.UserCreateRequest;
import com.onebyte.life4cut.user.domain.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureRestDocs
@WebMvcTest(value = {UserController.class})
@ExtendWith({MockitoExtension.class, RestDocumentationExtension.class})
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Nested
    class Create {
        @Test
        @DisplayName("유저를 생성하고 유저아이디를 반환한다")
        void createUserAndResponseUserId() throws Exception {
            // given
            UserCreateRequest request = new UserCreateRequest("nickname", "email@gmail.com");

            when(userService.createUser(any(), any())).thenReturn(100L);

            // when
            ResultActions result = mockMvc.perform(
                    post("/v1/users")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request))
            );

            // then
            result
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("id", Matchers.equalTo(100)))
                    .andDo(
                            document(
                                    "Auth",
                                    requestFields(
                                            fieldWithPath("nickname").type(JsonFieldType.STRING).description("가입할 유저 닉네임"),
                                            fieldWithPath("email").type(JsonFieldType.STRING).description("가입할 유저 이메일")
                                    ),
                                    responseFields(
                                            fieldWithPath("id").type(JsonFieldType.NUMBER).description("가입된 유저 아이디")
                                    )
                            )
                    );
        }
    }

}