package exam02;

public class Ex01 {
    public static void main(String[] args) {

        // main 실행 -> add 실행
        // main함수는 항상 제일먼저 실행됨
        Student s1 = new Student(1000, "이름1", "과목1");
        // new : 메모리에 적절한 용량을 할당
        System.out.println(System.identityHashCode(s1));
        Student s2 = s1;
        s2.setId(1001);
        s2.setName("이름2");
        System.out.println("s2 : " + s2);
        System.out.println("s1 : " + s1);

    }


}
