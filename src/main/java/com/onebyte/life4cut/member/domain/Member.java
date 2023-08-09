package com.onebyte.life4cut.member.domain;

import com.onebyte.life4cut.member.domain.vo.MemberRole;
import com.onebyte.life4cut.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Member extends BaseEntity {

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long albumId;
}
