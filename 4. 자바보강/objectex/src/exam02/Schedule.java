package exam02;

public class Schedule {
    private int year;
    private int month;
    private int day;

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        if(this.month == 2 && day > 28){
            this.day = 28;
        }
        else{
            this.day = day;
        }
    }

    void showDate(){
        System.out.printf("year=%d, month=%d, day=%d%n", year, month, day);
    }
}
