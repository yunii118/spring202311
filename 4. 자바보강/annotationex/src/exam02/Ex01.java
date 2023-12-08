package exam02;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@MyAnno2(nums={10,20, 30, 40}) // "값"이라고 해도 동일
public class Ex01 {
    public static void main(String[] args) {
        Class<Ex01> cls = Ex01.class;
        MyAnno2 anno = cls.getAnnotation(MyAnno2.class);
        String value = anno.value();
        System.out.printf("value = %s%n", value);

        int[] nums = anno.nums();
        System.out.println(Arrays.toString(nums));
    }
}
