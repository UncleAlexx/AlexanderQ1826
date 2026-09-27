package by.itstep.lesson5;

import java.math.BigDecimal;
import java.util.Locale;

public abstract class Employee extends Person{

    private Position position;

    public final BigDecimal experience;

    public final BigDecimal baseRate = new BigDecimal(10000);

    public Employee(String name, String surname, List intervals, Position position) {
        super(name, surname);
        setPosition(position);
        experience = Interval.intervalsToYears(intervals);
    }

    protected abstract void setPosition(Position position);

    public void setPositionBase(Position position){
        if(this.position == null)
            this.position = position;
    }

    public BigDecimal getSalary() {
        return position.coefficient.multiply(experience).multiply(baseRate);
    }

    @Override
    public String toString() {
        return  """
                {
                    %s,
                    "salary" : %s,
                    "experience" : %s,
                    "position" : "%s"
                }""".formatted(JsonFormatter.cutCurlyBracesAndIdentations(getFullName()),
                String.format(Locale.US, "%f",getSalary()), String.format(Locale.US, "%f",experience), position);
    }

    public Position getPosition() {
        return position;
    }
}
