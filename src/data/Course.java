package data;

import java.io.Serializable;

public class Course implements Serializable {
    private String title;
    private String classCode;
    private int days;
    private String start;
    private String end;
    private int units;

    public Course(String title, String classCode, int days, String start, String end, int units) {
        this.title = title;
        this.classCode = classCode;
        this.days = days;
        this.start = start;
        this.end = end;
        this.units = units;
    }

    public String getTitle() {
        return title;
    }

    public String getClassCode() {
        return classCode;
    }

    public int getDays() {
        return days;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getUnits() {
        return units;
    }
}
