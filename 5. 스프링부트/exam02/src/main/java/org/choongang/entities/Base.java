package org.choongang.entities;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Getter
@Setter
@MappedSuperclass // 공통 속성화를 위한 상위 클래스 지정
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {
    // 공통으로 사용되는 항목들
    // 바로 객체 만들지 않고 상속받아 사용할 수 있도록
    // -> abstract

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime modifiedAt;
}
