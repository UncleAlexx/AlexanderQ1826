package by.itstep.lesson5;

import java.math.BigDecimal;

public final class Director extends Employee{

    private final List subordinates;

    private static final long PER_SUBORDINATE_FEE = 100;

    public Director(String name, String surname, List intervals, int subordinatedCount) {
        super(name, surname, intervals, Position.DIRECTOR);
        subordinates = new List(subordinatedCount);
    }

    public void addWorker(Employee employee){
        subordinates.Add(employee);
    }

    @Override
    protected void setPosition(Position position) {
        setPositionBase(position);
    }

    @Override
    public BigDecimal getSalary() {
        var subordinatesCount = 0;
        for (int i = 0; i < subordinates.count(); i++) {
            if(subordinates.getByIndex(i) != null){
                subordinatesCount++;
            }
        }
        return super.getSalary().add(BigDecimal.valueOf(subordinatesCount * PER_SUBORDINATE_FEE));
    }

    @Override
    public String toString() {
        String directorInfo = """
        {
            %s,
        """.formatted(JsonFormatter.cutCurlyBracesAndIdentations(super.toString()));

        directorInfo  +=
            """
                "subordinates" :
                [
            """;
        for (int i = 0; i < subordinates.count(); i++) {
            if (subordinates.getByIndex(i) == null)
                break;
            directorInfo +=
            """ 
                    %s%s
            """.formatted(subordinates.getByIndex(i).toString().replaceAll("\n", "\n\t\t"),
                    i == subordinates.count() - 1 || i < subordinates.count() - 1 && subordinates.getByIndex(i+1) == null? "" : ",");
        }
        directorInfo+=
        """
            ]
        }""";
        return  directorInfo;
    }
}
