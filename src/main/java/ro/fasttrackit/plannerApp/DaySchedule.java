package ro.fasttrackit.plannerApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaySchedule {
    private final Days day;
    private final List<String> activities;

    public DaySchedule(Days day, List<String> activities){
        this.day = day;
        this.activities = new ArrayList<>(activities);
    }

    public DaySchedule(Days day){
        this.day = day;
        activities = new ArrayList<>();
    }

    public Days getDay() {
        return day;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void addActivity(String activity){
        activities.add(activity);
    }

    public void removeActivity(String activity) {
        activities.remove(activity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaySchedule schedule = (DaySchedule) o;
        return day == schedule.day &&
                Objects.equals(activities, schedule.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, activities);
    }
}
