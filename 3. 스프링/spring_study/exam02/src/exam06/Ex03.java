package exam06;

public class Ex03 {
    public static void main(String[] args) {
        Transportation bus = Transportation.BUS;
        System.out.printf("ordinal : %d, name : %s%n", bus.ordinal(), bus.name());

        Transportation subway = Enum.valueOf(Transportation.class, "SUBWAY");
        System.out.println(subway);
    }


}
