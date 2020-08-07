package com.bucur.interval;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RepeatIntervalConverterTest {

    @Test
    public void givenFrequency_shouldConvertToString() {
        RepeatIntervalConverter converter = new RepeatIntervalConverter();
        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

        RepeatInterval repeatInterval = builder
            .withFrequency(Frequency.DAILY.getValue())
            .build();

        String actual = converter.convertFrequency(repeatInterval);

        assertThat(actual).isEqualTo("FREQ=DAILY;");
    }

    @Test
    public void givenInterval2_shouldConvertToString() {
        RepeatIntervalConverter converter = new RepeatIntervalConverter();
        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

        RepeatInterval repeatInterval = builder
            .withInterval(2)
            .build();

        String actual = converter.convertInterval(repeatInterval);

        assertThat(actual).isEqualTo("INTERVAL=2;");
    }

    @Test
    public void givenDays_shouldConvertToString() {
        RepeatIntervalConverter converter = new RepeatIntervalConverter();
        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

        Map<DayOfWeek, Boolean> days = new TreeMap<>();
        days.put(DayOfWeek.WED, true);
        days.put(DayOfWeek.MON, true);

        RepeatInterval repeatInterval = builder
            .byDay(days)
            .build();

        String actual = converter.convertDays(repeatInterval);

        assertThat(actual).isEqualTo("BYDAY=MON,WED;");
    }

    @Test
    public void givenTime_shouldConvertToString() {
        RepeatIntervalConverter converter = new RepeatIntervalConverter();
        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

        String time = "12:20:30";

        RepeatInterval repeatInterval = builder
            .byTime(time)
            .build();

        String actual = converter.convertTime(repeatInterval);

        assertThat(actual).isEqualTo("BYHOUR=12;BYMINUTE=20;BYSECOND=30;");
    }

    @Test
    public void givenMonthDays_shouldConvertToString() {
        RepeatIntervalConverter converter = new RepeatIntervalConverter();
        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

        Set<Integer> monthDays = new TreeSet<>();
        monthDays.add(31);
        monthDays.add(1);

        RepeatInterval repeatInterval = builder
            .byMonthDay(monthDays)
            .build();

        String actual = converter.convertMonthDays(repeatInterval);

        assertThat(actual).isEqualTo("BYMONTHDAY=1,31;");
    }

    @Test
    public void givenWeekDays_shouldConvertToString() {
        RepeatIntervalConverter converter = new RepeatIntervalConverter();
        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

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

        RepeatInterval repeatInterval = builder
            .byWeekDay(weekDays)
            .build();

        String actual = converter.convertWeekDays(repeatInterval);

        assertThat(actual).isEqualTo("BYDAY=-1MON,MON,1MON,-1TUE,TUE,1TUE;");
    }

    /* Append tests */

    @Test
    public void givenFrequency_shouldBuildString() {
        RepeatIntervalConverter converter = new RepeatIntervalConverter();
        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

        RepeatInterval repeatInterval = builder
            .withFrequency(Frequency.DAILY.getValue())
            .build();

        String actual = converter.append(repeatInterval);

        assertThat(actual).isEqualTo("FREQ=DAILY;");
    }

    @Test
    public void givenFrequencyInterval_shouldBuildString() {
        RepeatIntervalConverter converter = new RepeatIntervalConverter();

        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();
        RepeatInterval repeatInterval = builder
            .withFrequency(Frequency.DAILY.getValue())
            .withInterval(2)
            .build();

        String actual = converter.append(repeatInterval);

        assertThat(actual).isEqualTo("FREQ=DAILY;INTERVAL=2;");
    }

    @Test
    public void givenFrequencyDays_shouldBuildString() {
        RepeatIntervalConverter converter = new RepeatIntervalConverter();

        RepeatIntervalBuilder builder = new RepeatIntervalBuilder();

        Map<DayOfWeek, Boolean> days = new TreeMap<>();
        days.put(DayOfWeek.WED, true);
        days.put(DayOfWeek.MON, true);

        RepeatInterval repeatInterval = builder
            .withFrequency(Frequency.DAILY.getValue())
            .byDay(days)
            .build();

        String actual = converter.append(repeatInterval);

        assertThat(actual).isEqualTo("FREQ=DAILY;BYDAY=MON,WED;");
    }

    @Test
    public void givenDaysOfWeek_shouldCompare() {
        WeekDayObject one = new WeekDayObject(0, DayOfWeek.MON);
        WeekDayObject two = new WeekDayObject(0, DayOfWeek.TUE);

        assertThat(one.compareTo(two)).isEqualTo(-1);
    }

    @Test
    public void givenDaysOfWeek1_shouldCompare() {
        WeekDayObject one = new WeekDayObject(-1, DayOfWeek.MON);
        WeekDayObject two = new WeekDayObject(0, DayOfWeek.MON);

        assertThat(one.compareTo(two)).isEqualTo(-1);
    }

    @Test
    public void givenDaysOfWeek2_shouldCompare() {
        WeekDayObject one = new WeekDayObject(0, DayOfWeek.MON);
        WeekDayObject two = new WeekDayObject(1, DayOfWeek.MON);

        assertThat(one.compareTo(two)).isEqualTo(-1);
    }

    @Test
    public void sort_shouldCompare() {
        WeekDayObject act1 = new WeekDayObject(-1, DayOfWeek.MON);
        WeekDayObject act2 = new WeekDayObject(0, DayOfWeek.MON);
        WeekDayObject act3 = new WeekDayObject(1, DayOfWeek.MON);
        WeekDayObject act4 = new WeekDayObject(-1, DayOfWeek.TUE);
        WeekDayObject act5 = new WeekDayObject(0, DayOfWeek.TUE);
        WeekDayObject act6 = new WeekDayObject(1, DayOfWeek.TUE);

        List<WeekDayObject> actual = new ArrayList<>();
        actual.add(act3);
        actual.add(act4);
        actual.add(act1);
        actual.add(act5);
        actual.add(act2);
        actual.add(act6);

        Collections.sort(actual);

        WeekDayObject exp1 = new WeekDayObject(-1, DayOfWeek.MON);
        WeekDayObject exp2 = new WeekDayObject(0, DayOfWeek.MON);
        WeekDayObject exp3 = new WeekDayObject(1, DayOfWeek.MON);
        WeekDayObject exp4 = new WeekDayObject(-1, DayOfWeek.TUE);
        WeekDayObject exp5 = new WeekDayObject(0, DayOfWeek.TUE);
        WeekDayObject exp6 = new WeekDayObject(1, DayOfWeek.TUE);

        List<WeekDayObject> expected = new ArrayList<>();
        expected.add(exp1);
        expected.add(exp2);
        expected.add(exp3);
        expected.add(exp4);
        expected.add(exp5);
        expected.add(exp6);

        assertThat(actual).isEqualTo(expected);
    }
}
