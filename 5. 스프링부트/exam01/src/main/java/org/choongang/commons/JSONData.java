package org.choongang.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class JSONData<T> {
    // 요청 성공이든 실패든
    // 동일한 형식의 응답 반환하기 위해서 사용하는 클래스
    private boolean success = true; // 오류발생했을때만 false
    private HttpStatus status = HttpStatus.OK; // 응답 상태 코드

    @NonNull
    private T data; // 성공시 응답바디 데이터
    private String message; // 실패시 메세지



}
