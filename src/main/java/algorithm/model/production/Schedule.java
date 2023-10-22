package algorithm.model.production;

import parse.input.production.InputSchedule;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Класс для Алгоритма</b>
 * <b>Расписание производства</b>
 * <p>В будущем можно будет добавить выходные, время отдыха и т.д.</p>
 */
public class Schedule implements Serializable {

    /**
     * Список дней недели
     */
    private List<WorkingDay> week;

    public Schedule() {

    }

    public Schedule(InputSchedule inputSchedule) {
        ArrayList<WorkingDay> week = new ArrayList<>();
        inputSchedule.getWeek().forEach(workingDay -> {
            week.add(new WorkingDay(workingDay));
        });
        this.week = week;
    }

    public Schedule(List<WorkingDay> week) {
        this.week = week;
    }

    public List<WorkingDay> getWeek() {
        return week;
    }

    public boolean checkWorkDayInScheduleByDayNumber(Short dayNumber) {
        for(WorkingDay day : week) {
            if(day.getDayNumber().equals(dayNumber)) {
                return true;
            }
        }
        return false;
    }

    public WorkingDay getWorkDayByDayNumber(Short dayNumber) {
        for(WorkingDay day : week) {
           if(day.getDayNumber().equals(dayNumber)) {
               return day;
           }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "week=" + week +
                '}';
    }
}
