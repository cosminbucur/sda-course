package com.sda.testing.tdd.interval;

public class WeekDayObject implements Comparable<WeekDayObject> {

    private int weekDayNo;
    private DayOfWeek weekDay;

    public WeekDayObject(int weekDayNo, DayOfWeek weekDay) {
        this.weekDayNo = weekDayNo;
        this.weekDay = weekDay;
    }

    @Override
    public int compareTo(WeekDayObject that) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == that) return EQUAL;

        int comparison = this.weekDay.compareTo(that.weekDay);

        if (comparison != EQUAL) return comparison;

        if (this.weekDayNo < that.weekDayNo) return BEFORE;
        if (this.weekDayNo > that.weekDayNo) return AFTER;

        assert this.equals(that);

        return EQUAL;
    }

    public int getWeekDayNo() {
        return weekDayNo;
    }

    public void setWeekDayNo(int weekDayNo) {
        this.weekDayNo = weekDayNo;
    }

    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(DayOfWeek weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeekDayObject that = (WeekDayObject) o;

        if (weekDayNo != that.weekDayNo) return false;
        return weekDay == that.weekDay;
    }

    @Override
    public int hashCode() {
        int result = weekDayNo;
        result = 31 * result + (weekDay != null ? weekDay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if (weekDayNo == 0) {
            return weekDay.toString();
        }
        return Integer.toString(weekDayNo) + weekDay;
    }
}
