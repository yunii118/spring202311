package org.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor // 기본생성자 private으로 생성되어있음 -> 이를 해결하기 위해
@AllArgsConstructor // 생성자 다 없애고 모든 생성자를 추가시킴
public class Member {
    // USER_NO -> userNo 알아서 매핑됨
    @Id // 기본키임을 알려줌
    private Long userNo;
    private String userId;
    @JsonIgnore
    private String userPw;
    private String userNm;
    private String email;
    @JsonFormat(pattern = "yyyy.MM.dd hh:mm")
    private LocalDateTime regDt;
    @JsonFormat(pattern = "yyyy.MM.dd hh:mm")
    private LocalDateTime modDt;


}
