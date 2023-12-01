package exam04;

public class Ex03 {
    public static void main(String[] args) {
        Book3 b3 = new Book3("책3", "저자3", "출판사3");
        System.out.printf("title = %s, author = %s, publisher = %s%n", b3.title(), b3.author(), b3.publisher());
        System.out.println(b3);
    }
}
