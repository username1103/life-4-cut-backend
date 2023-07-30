package com.onebyte.life4cut.user.domain;

import com.onebyte.life4cut.common.vo.EmailConverter;
import com.onebyte.life4cut.common.entity.BaseEntity;
import com.onebyte.life4cut.common.vo.Address;
import com.onebyte.life4cut.common.vo.Email;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class User extends BaseEntity {

    @Column()
    private String nickname;

    @Column()
    @Convert(converter = EmailConverter.class)
    private Email email;

    @Embedded
    private Address address;

    protected User(String nickname, Email email, Address address) {
        this.nickname = nickname;
        this.email = email;
        this.address = address;
    }

    public static User create(String nickname, Email email, Address address) {
        return new User(nickname, email, address);
    }
}
