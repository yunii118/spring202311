package exam01;

import static exam01.Transportation.*;
public class Ex01 {
    public static void main(String[] args) {
        Transportation bus = BUS;
        System.out.println(bus == Transportation.BUS);
        System.out.printf("ordinal() : %d, name() : %s%n", BUS.ordinal(), BUS.name());

    }
}
