package com.sda.testing.tdd.interval;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RepeatIntervalBuilder {

    private String frequency;
    private int interval;
    private Set<String> times = new TreeSet<>();
    private String time;
    private Set<Integer> monthDays = new TreeSet<>();
    private Set<WeekDayObject> weekDays = new TreeSet<>();
    private Map<DayOfWeek, Boolean> days = new TreeMap<>();
    private Set<Integer> hours;
    private Set<Integer> minutes;
    private Set<Integer> seconds;

    public RepeatInterval build() {
        return new RepeatInterval(frequency, interval, times, time, monthDays, weekDays, days, hours, minutes, seconds);
    }

    public RepeatIntervalBuilder withFrequency(String frequency) {
        this.frequency = frequency;
        return this;
    }

    public RepeatIntervalBuilder withInterval(int interval) {
        this.interval = interval;
        return this;
    }

    public RepeatIntervalBuilder byMonthDay(Set<Integer> monthDays) {
        this.monthDays = monthDays;
        return this;
    }

    public RepeatIntervalBuilder byWeekDay(Set<WeekDayObject> weekDays) {
        this.weekDays = weekDays;
        return this;
    }

    public RepeatIntervalBuilder byDay(Map<DayOfWeek, Boolean> days) {
        this.days = days;
        return this;
    }

    public RepeatIntervalBuilder byTime(Set<String> times) {
        this.times = times;
        return this;
    }

    public RepeatIntervalBuilder byTime(String time) {
        this.time = time;
        return this;
    }

    public RepeatIntervalBuilder byHour(Set<Integer> hours) {
        this.hours = hours;
        return this;
    }

    public RepeatIntervalBuilder byMinute(Set<Integer> minutes) {
        this.minutes = minutes;
        return this;
    }

    public RepeatIntervalBuilder bySecond(Set<Integer> seconds) {
        this.seconds = seconds;
        return this;
    }
}
