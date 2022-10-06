package com.credibanco.assessment.card.utilities;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class TiempoTranscurrido {
    public static Integer minutoTranscurridos(Date tiempoDb){
        Instant instant = tiempoDb.toInstant();
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        LocalTime tiempo = LocalTime.ofInstant(instant, zoneId);

        Date current = new Date();
        Instant instantCurrent = current.toInstant();
        ZoneId zoneIdCurrent = TimeZone.getDefault().toZoneId();
        LocalTime localTimeCurrent = LocalTime.ofInstant(instantCurrent, zoneIdCurrent);

        LocalTime result =
                localTimeCurrent.minusHours(tiempo.getHour())
                        .minusMinutes(tiempo.getMinute())
                        .minusSeconds(tiempo.getSecond());

        Integer minute = result.getMinute();

        return minute;
    }
}
