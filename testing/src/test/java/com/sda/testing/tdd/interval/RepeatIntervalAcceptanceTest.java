package com.sda.testing.tdd.interval;

import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class RepeatIntervalAcceptanceTest {

    @Test
    public void daily_acceptanceTest() {
        String expected = "FREQ=DAILY;INTERVAL=2;BYHOUR=12;BYMINUTE=20;BYSECOND=30;BYDAY=MON,TUE,WED,THU,FRI,SAT,SUN;";

        Map<DayOfWeek, Boolean> days = new TreeMap<>();
        days.put(DayOfWeek.SUN, true);
        days.put(DayOfWeek.MON, true);
        days.put(DayOfWeek.TUE, true);
        days.put(DayOfWeek.WED, true);
        days.put(DayOfWeek.THU, true);
        days.put(DayOfWeek.FRI, true);
        days.put(DayOfWeek.SAT, true);

        String frequency = Frequency.DAILY.getValue();

        Integer interval = 2;

        String time = "12:20:30";

        Set<Integer> hours = new TreeSet<>();
        hours.add(6);
        hours.add(5);

        Set<Integer> minutes = new TreeSet<>();
        minutes.add(59);
        minutes.add(0);

        Set<Integer> seconds = new TreeSet<>();
        seconds.add(59);
        seconds.add(0);

        RepeatIntervalConverter converter = new RepeatIntervalConverter();
        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

        RepeatInterval repeatInterval = builder
            .withFrequency(frequency)
            .withInterval(interval)
            .byTime(time)
            .byDay(days)
            .byHour(hours)
            .byMinute(minutes)
            .bySecond(seconds)
            .build();

        String actual = converter.append(repeatInterval);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void monthly_acceptanceTest() {
        String expected = "FREQ=MONTHLY;INTERVAL=2;BYHOUR=12;BYMINUTE=20;BYSECOND=30;BYMONTHDAY=1,31;BYDAY=-1MON,MON,1MON,-1TUE,TUE,1TUE;";

        Map<DayOfWeek, Boolean> days = new TreeMap<>();
        days.put(DayOfWeek.TUE, true);
        days.put(DayOfWeek.MON, true);
        days.put(DayOfWeek.WED, true);

        String frequency = Frequency.MONTHLY.getValue();

        Integer interval = 2;

        String time = "12:20:30";

        Set<Integer> monthDays = new TreeSet<>();
        monthDays.add(31);
        monthDays.add(1);

        Set<WeekDayObject> weekDays = new TreeSet<>();
        WeekDayObject act1 = new WeekDayObject(-1, DayOfWeek.MON);
        WeekDayObject act2 = new WeekDayObject(0, DayOfWeek.MON);
        WeekDayObject act3 = new WeekDayObject(1, DayOfWeek.MON);
        WeekDayObject act4 = new WeekDayObject(-1, DayOfWeek.TUE);
        WeekDayObject act5 = new WeekDayObject(0, DayOfWeek.TUE);
        WeekDayObject act6 = new WeekDayObject(1, DayOfWeek.TUE);
        weekDays.add(act3);
        weekDays.add(act4);
        weekDays.add(act1);
        weekDays.add(act5);
        weekDays.add(act2);
        weekDays.add(act6);

        RepeatIntervalConverter converter = new RepeatIntervalConverter();
        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

        RepeatInterval repeatInterval = builder
            .withFrequency(frequency)
            .withInterval(interval)
            .byTime(time)
            .byMonthDay(monthDays)
            .byWeekDay(weekDays)
            .build();

        String actual = converter.append(repeatInterval);

        assertThat(actual).isEqualTo(expected);
    }
}
