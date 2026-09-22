package by.itstep.lesson4.FirstProblem;

public class MonthExtensions {
    public static String getSeasonByMonth(String monthRaw){

        Month month = null;

        for(Month value : Month.values()) {
            if(value.name().equalsIgnoreCase(monthRaw)){
                month = value;
                break;
            }
        }

        return month == null ? null : Season.values()[month.ordinal() / 3].name();
    }
}
