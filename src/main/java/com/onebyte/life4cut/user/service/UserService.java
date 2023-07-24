package com.onebyte.life4cut.user.service;

import com.onebyte.life4cut.common.vo.Address;
import com.onebyte.life4cut.common.vo.Email;
import com.onebyte.life4cut.user.domain.User;
import com.onebyte.life4cut.user.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepositoryImpl userRepository;

    public UserService(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Long createUser(Email email, String nickname, Address address) {
        User user = userRepository.save(User.create(nickname, email, address));

        return user.getId();
    }
}
