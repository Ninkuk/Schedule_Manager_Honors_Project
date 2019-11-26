package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    private String title;
    private String classCode;
    private ArrayList<String> days;
    private String start;
    private String end;
    private int units;

    public Course(String title, String classCode, ArrayList<String> days, String start, String end, int units) {
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

    public String getDays() {
        String daysList = "";
        for (String day : days) {
            daysList += day + " ";
        }
        return daysList;
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
