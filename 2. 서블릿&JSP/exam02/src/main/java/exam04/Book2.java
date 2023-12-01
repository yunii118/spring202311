package exam04;

import lombok.Builder;
import lombok.ToString;

// build up pattern 생성
@Builder
@ToString
public class Book2 {
    private String title;
    private String author;
    private String publisher;

}
