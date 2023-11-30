package exam01;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor(access = AccessLevel.PRIVATE) // 기본 생성자
//@AllArgsConstructor // 모든 멤버 변수 초기화 생성자
//@RequiredArgsConstructor // 값이 꼭 있어야하는 인자(final, not null 등)으로 생성자 만들어줌

@Data // getter, setter, tostring, EqualsandHashcode
public class Book {
    private String title;
    private String author;
    private String publisher;


}