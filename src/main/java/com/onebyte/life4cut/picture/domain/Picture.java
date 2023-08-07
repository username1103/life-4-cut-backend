package com.onebyte.life4cut.picture.domain;

import com.onebyte.life4cut.common.entity.BaseEntity;
import com.onebyte.life4cut.common.vo.UrlPath;
import com.onebyte.life4cut.common.vo.UrlPathConverter;
import com.onebyte.life4cut.picture.domain.vo.PictureFrame;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)

public class Picture extends BaseEntity {

    @Column(nullable = false)
    private Long albumId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, length = 500)
    @Convert(converter = UrlPathConverter.class)
    private UrlPath path;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contents;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private PictureFrame frame;

    @Column(nullable = false)
    private LocalDateTime picturedAt;

    @Column
    private LocalDateTime deletedAt;

    @ElementCollection
    @CollectionTable(name = "picture_tag", joinColumns = @JoinColumn(name = "picture_id"))
    private List<PictureTag> tags;
}
