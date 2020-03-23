package ro.fasttrackit.plannerApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private final List<DaySchedule> daySchedules = new ArrayList<>();;


    public List<DaySchedule> getDaySchedules() {
        return daySchedules;
    }

    public void addActivity(Days day, String activity){
        if(activity.equals(null)){
            throw  new NoActivityException("No activity");
        }
        DaySchedule schedule = findDaySchedule(day);
        if (schedule==null){
            schedule = new DaySchedule(day);
            daySchedules.add(schedule);
            schedule.addActivity(activity);
        }else{
            schedule.addActivity(activity);
        }

    }

    public void removeActivity(Days day,String activity){
        if(activity == null){
            throw new NoActivityException("No activity");
        }
        DaySchedule daySchedule = findDaySchedule(day);
        daySchedule.removeActivity(activity);

    }

    public List<String> getActivities(Days day){
        DaySchedule schedule = findDaySchedule(day);
        if(schedule == null){
            return List.of();
        }else {
            return schedule.getActivities();
        }
    }

    public Map<Days, List<String>> endPlanning(){
        Map<Days, List<String>> dayToActivites = new HashMap<>();
        for(DaySchedule schedule: daySchedules){
            if(schedule.getActivities()== null){
                throw new NoActivityException("No activites");
            }
            dayToActivites.put(schedule.getDay(),schedule.getActivities());
        }
        return dayToActivites;
    }

    public DaySchedule findDaySchedule(Days day){
        for(DaySchedule schedule: daySchedules){
           if(schedule.getDay().equals(day)){
               return schedule;
           }
        }
        return null;
    }
}
