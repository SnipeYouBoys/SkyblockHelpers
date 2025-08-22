package com.snipeyouboys.skyblockhelpers;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    public static String getTimeWithOffset(int offsetHours) {
        ZoneOffset offset = ZoneOffset.ofHours(offsetHours);
        ZonedDateTime time = Instant.now().atZone(offset);
        return FORMATTER.format(time);
    }
}