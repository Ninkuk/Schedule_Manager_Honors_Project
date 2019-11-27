package data;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Course implements Serializable {
    private String title;
    private int classCode;
    private ArrayList<String> days;
    private LocalTime start;
    private LocalTime end;
    private int units;

    public Course(String title, int units) {
        this.title = title;
        this.classCode = setClassCode();

        this.days = new ArrayList<>();

        if (units == 3) {
            this.days.add("M");
            this.days.add("W");
            this.days.add("F");
        } else if (units == 2) {
            this.days.add("T");
            this.days.add("Th");
        } else {
            this.days.add("F");
        }

        setStartEndTime(units);
        this.units = units;
    }

    private int setClassCode() {
        Random random = new Random();
        int classCodeRandom = random.nextInt(9000) + 1000;
        for (int i = 0; i < HandleData.coursesList.size(); i++) {
            if (HandleData.coursesList.get(i).getClassCode() == classCodeRandom) {
                i = 0;
                classCodeRandom = random.nextInt(10000);
            }
        }

        return classCodeRandom;
    }

    private void setStartEndTime(int units) {
        Random random = new Random();
        boolean bool = random.nextBoolean();
        LocalTime time = LocalTime.NOON;
        LocalTime startTime;
        if (bool) {
            startTime = time.plus(Duration.ofMinutes(random.nextInt(60) * 5));
            this.start = startTime;
            this.end = startTime.plus(Duration.ofHours(units));
        } else {
            startTime = time.minus(Duration.ofMinutes(random.nextInt(80) * 5));
            this.start = startTime;
            this.end = startTime.plus(Duration.ofHours(units));
        }
    }

    public String getTitle() {
        return title;
    }

    public int getClassCode() {
        return classCode;
    }

    public String getDays() {
        String daysList = "";
        for (String day : days) {
            daysList += day + " ";
        }
        return daysList;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public int getUnits() {
        return units;
    }
}
