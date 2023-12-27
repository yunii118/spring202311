package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class BoardData extends Base{
    @Id
    @GeneratedValue
    private Long seq; // Wrapper 클래스가 적합
    @Column(length = 100, nullable = false)
    private String subject;
    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userNo")
    private Member member;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<HashTag> tags = new ArrayList<>();

}
