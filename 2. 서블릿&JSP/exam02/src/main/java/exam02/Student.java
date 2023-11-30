package exam02;

import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@ToString
public class Student {
    private int id;
    private String name;
    private String subject;

    public Student(){
        // 객체 생성 이후 실행
        id=1000;
    }
    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        Student s2 = (Student) obj;
        if(id == s2.id && name.equals(s2.name) && subject.equals(s2.subject)){
            equal = true;
        }
        return equal;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, subject);
    }
}
