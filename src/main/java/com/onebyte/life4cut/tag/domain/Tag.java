package com.onebyte.life4cut.tag.domain;

import com.onebyte.life4cut.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)

public class Tag extends BaseEntity {
    @Column(nullable = false)
    private Long albumId;
    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column
    private LocalDateTime deletedAt;
}
