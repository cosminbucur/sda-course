package com.sda.testing.tdd.interval;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RepeatInterval {

    private String frequency;
    private int interval;
    private Set<String> times;
    private String time;
    private Set<Integer> monthDays = new TreeSet<>();
    private Set<WeekDayObject> weekDays = new TreeSet<>();
    private Map<DayOfWeek, Boolean> days;
    private Set<Integer> hours;
    private Set<Integer> minutes;
    private Set<Integer> seconds;

    public RepeatInterval(String frequency, int interval, Set<String> times, String time, Set<Integer> monthDays, Set<WeekDayObject> weekDays, Map<DayOfWeek, Boolean> days, Set<Integer> hours,
                          Set<Integer> minutes, Set<Integer> seconds) {
        this.frequency = frequency;
        this.interval = interval;
        this.times = times;
        this.time = time;
        this.monthDays = monthDays;
        this.weekDays = weekDays;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public RepeatInterval() {
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public Set<String> getTimes() {
        return times;
    }

    public void setTimes(Set<String> times) {
        this.times = times;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Set<Integer> getMonthDays() {
        return monthDays;
    }

    public void setMonthDays(Set<Integer> monthDays) {
        this.monthDays = monthDays;
    }

    public Set<WeekDayObject> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(Set<WeekDayObject> weekDays) {
        this.weekDays = weekDays;
    }

    public Map<DayOfWeek, Boolean> getDays() {
        return days;
    }

    public void setDays(Map<DayOfWeek, Boolean> days) {
        this.days = days;
    }

    public Set<Integer> getHours() {
        return hours;
    }

    public void setHours(Set<Integer> hours) {
        this.hours = hours;
    }

    public Set<Integer> getMinutes() {
        return minutes;
    }

    public void setMinutes(Set<Integer> minutes) {
        this.minutes = minutes;
    }

    public Set<Integer> getSeconds() {
        return seconds;
    }

    public void setSeconds(Set<Integer> seconds) {
        this.seconds = seconds;
    }
}
