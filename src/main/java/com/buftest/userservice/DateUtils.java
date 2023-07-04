package com.buftest.userservice;

import com.google.type.DateTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

  public static DateTime convertToDateTime(String iso8601String) {
    LocalDateTime localDateTime = LocalDateTime.parse(iso8601String,
      DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneOffset.UTC);

    long seconds = zonedDateTime.toEpochSecond();
    int nanos = zonedDateTime.getNano();

    DateTime dateTime = DateTime.newBuilder()
      .setSeconds((int) seconds)
      .setNanos(nanos)
      .build();

    return dateTime;
  }

}
