package com.bucur.interval;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatIntervalConverter {

    public String append(RepeatInterval repeatInterval) {
        String frequency = convertFrequency(repeatInterval);
        String interval = convertInterval(repeatInterval);
        String time = convertTime(repeatInterval);
        String monthDays = convertMonthDays(repeatInterval);
        String weekDays = convertWeekDays(repeatInterval);
        String days = convertDays(repeatInterval);

        return frequency + interval + time + monthDays + weekDays + days;
    }

    public String convertFrequency(RepeatInterval repeatInterval) {
        return "FREQ=" + repeatInterval.getFrequency() + ";";
    }

    public String convertInterval(RepeatInterval repeatInterval) {
        if (repeatInterval.getInterval() == 0 || repeatInterval.getInterval() == 1) {
            return "";
        }

        return "INTERVAL=" + repeatInterval.getInterval() + ";";
    }

    public String convertTime(RepeatInterval repeatInterval) {
        String time = repeatInterval.getTime();

        if (time == null || time.isEmpty()) {
            return "";
        }

        String[] result = StringUtils.split(time, ":");

        String hour = result[0];
        String minute = result[1];
        String second = result[2];

        return "BYHOUR=" + hour + ";BYMINUTE=" + minute + ";BYSECOND=" + second + ";";
    }

//    public String convertTime(RepeatInterval repeatInterval) {
//        Set<String> times = repeatInterval.getTimes();
//
//        if (times == null || times.isEmpty()) {
//            return "";
//        }
//
//        String result = StringUtils.join(times, ",").replace(":", "");
//
//        return "BYTIME=" + result + ";";
//    }

    public String convertMonthDays(RepeatInterval repeatInterval) {
        Set<Integer> monthDays = repeatInterval.getMonthDays();

        if (monthDays == null || monthDays.isEmpty()) {
            return "";
        }

        String result = StringUtils.join(monthDays, ",");

        return "BYMONTHDAY=" + result + ";";
    }

    public String convertWeekDays(RepeatInterval repeatInterval) {
        Set<WeekDayObject> weekDays = repeatInterval.getWeekDays();

        if (weekDays == null || weekDays.isEmpty()) {
            return "";
        }

        String result = StringUtils.join(weekDays, ",");

        return "BYDAY=" + result + ";";
    }

    public String convertDays(RepeatInterval repeatInterval) {
        Map<DayOfWeek, Boolean> days = repeatInterval.getDays();

        if (days == null || days.isEmpty()) {
            return "";
        }

        String result = days.keySet()
            .stream()
            .map(Object::toString)
            .collect(Collectors.joining(","));

        return "BYDAY=" + result + ";";
    }
}
