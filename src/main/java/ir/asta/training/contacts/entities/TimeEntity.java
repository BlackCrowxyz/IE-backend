package ir.asta.training.contacts.entities;

/**
 * Created by ASUS on 5/8/2019.
 */
public class TimeEntity {
    int year;
    int month;
    int day;
    String text;

    public TimeEntity(){

    }

    public TimeEntity(int year, int month, int day, String text) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.text = text;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
