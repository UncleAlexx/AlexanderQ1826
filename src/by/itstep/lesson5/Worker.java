package by.itstep.lesson5;

public final class Worker extends Employee{

    public Worker(String name, String surname, List experienceIntervals) {
        super(name, surname, experienceIntervals, Position.WORKER);
    }

    @Override
    protected void setPosition(Position position) {
        setPositionBase(position);
    }
}
