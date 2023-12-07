package exam01;

public class Book {

    private String title;

    @Override // target : METHOD, 함수에만 적용가능
    public String toString(){
        return title;
    }
}
