package com.choongang.entities;

import com.choongang.commons.MemberType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "USERS", // 테이블명 변경
        indexes = @Index(name = "idx_member_createdAt", columnList = "createdAt DESC"))
//@EntityListeners(AuditingEntityListener.class) // entity 변화 감지
public class Member extends Base {
    @Id
    @GeneratedValue // 시퀀스 만들어짐
    private Long seq;
    @Column(length = 80, unique = true, nullable = false)
    private String email;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 65, name = "userPw", nullable = false) // 이름 바꺼주기
    private String password; // varchar2
    // @Lob // CLOB 형태로 만들어짐, Large Object
    @Transient // 엔티티에서만 사용, 테이블에 반영 안되게
    private String introduction;
    @Column(length=10)
    @Enumerated(EnumType.STRING) // enum class, ORDINAL로 할 경우 enum클래스에 타입 추가시 순번이 바뀌어 잘못된 권한이 부여될 수 있음
    private MemberType type; //
   /* @CreationTimestamp // INSERT SQL 실행시
    private LocalDateTime createdAt;
    //@UpdateTimestamp // UPDATE SQL 실행시
    @LastModifiedDate
    private LocalDateTime modifiedAt;*/

    @Temporal(TemporalType.DATE)
    public Date dt;
}

