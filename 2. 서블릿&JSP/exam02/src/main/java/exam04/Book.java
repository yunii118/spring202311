package exam04;

import exam03.B;

// build up 패턴
// method chaining

public class Book {
    private String title;
    private String author;
    private String publisher;
    private Book(){}

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    protected static class Builder{
        private Book instance = new Book();

        public Builder title(String title){
            instance.title = title;
            return this;
        }

        public Builder author(String author){
            instance.author = author;
            return this;
        }

        public Builder publisher(String publisher){
            instance.publisher = publisher;
            return this;
        }

        public Book build(){
            return instance;
        }

    }

}
