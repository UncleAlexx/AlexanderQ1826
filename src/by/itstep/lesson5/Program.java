package by.itstep.lesson5;

import java.time.ZonedDateTime;

final class Program {

    static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime lastYear = ZonedDateTime.now().minusYears(1);
        Interval oneYearInterval = new Interval(now, now.minusYears(1));
        List intervals = new List(1);
        intervals.Add(oneYearInterval);

        Employee[] employees =
        {
            new Worker("name","surname", intervals),
            new Worker("name1","surname1", intervals),
            new Worker("name2", "surname2", intervals),
            new Director("name3", "surname3", intervals, 3 )
        };
        System.out.println(employees[3].getFullName());

        Director employee = (Director) employees[employees.length - 1];

        employee.addWorker(employees[0]);
        employee.addWorker(employees[1]);
        Director director = new Director("name4", "surname4", intervals, 2);
        director.addWorker(employees[2]);
        employee.addWorker(director);

        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }

        System.out.println(director);
    }
}
