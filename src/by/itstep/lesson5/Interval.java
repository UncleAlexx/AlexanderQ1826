package by.itstep.lesson5;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZonedDateTime;

final class Interval {
     public long days;

     public Interval(ZonedDateTime one, ZonedDateTime other){
          days = (one.compareTo(other) > 0 ? Duration.between(other, one) : Duration.between(one, other)).toDays();
     }

     public static BigDecimal intervalsToYears(List intervals){
          long days = 0;
          final short daysInAYear = 365;

          for (int i = 0; i < 10; i++)
               if(intervals.getByIndex(i) != null)
                    days += ((Interval)intervals.getByIndex(i)).days;

          return new BigDecimal(days / daysInAYear);
     }
}
