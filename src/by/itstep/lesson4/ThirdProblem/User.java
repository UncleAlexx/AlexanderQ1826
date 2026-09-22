package by.itstep.lesson4.ThirdProblem;

import java.util.function.Predicate;

public class User {

    private String name;
    private String surname;
    private Sex sex;
    private int age;
    private final Address address;
    private Predicate<Object> isNotNull = x -> x != null;
    private Predicate<Integer> greaterThanNull = x -> x > 0;
    private Predicate<Integer> lessThanNull = x -> x > 0;

    public User(String name, String surname, Sex sex, int age, String country , String city){
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = getIfNullOrGreater(this.age, age);
        address = new Address(city, country);
    }

    public int get_Age(){
        return  age;
    }

    public Sex get_Sex(){

        return  sex;
    }

    public String get_Name(){
        return  name;
    }

    public String get_Surname(){
        return  surname;
    }

    public void set_Age(int age){
        this.age = (int)getIfNullOrGreater(this.age, age);
    }

    public void set_Sex(Sex sex){
        this.sex = (Sex)getIfNotNull(this.sex, sex);
    }

    public void set_Name(String name){
        this.name = (String)getIfNotNull(this.name, name);
    }

    public void set_Surname(String surname){
        this.surname = (String)getIfNotNull(this.surname, surname);
    }

    public void setAddress(String country, String city){
        this.address.city = (String)getIfNotNull(this.address.city, city);
        this.address.country  = (String)getIfNotNull(this.address.country, country);
    }

    public String getFullName(){
        return  name + " " + surname;
    }

    public void increaseAgeBy(int value){
        if (greaterThanNull.test(value) && lessThanNull.test(value + age))
            return;
        age += value;
    }

    @Override
    public String toString() {
        return  """
        {
          "name" : "%s",
          "age" : "%d",
          "surname" : "%s",
          "sex" : "%s",
          "country" : "%s",
          "city" : "%s"
        }
        """.formatted(name,age, surname, sex.toString().toLowerCase(), address.city, address.country);
    }


    private int getIfNullOrGreater(int toSet, int value) {
        return (int)getNewIfCondition(toSet , value, greaterThanNull.test(value));
    }

    private Object getIfNotNull(Object toSet, Object value) {
        return getNewIfCondition(toSet, value, isNotNull.test(value));
    }

    private Object getNewIfCondition(Object toSet, Object value, boolean condition) {
        return condition? value : toSet;
    }

    private class Address {
        private String country;
        private String city;
        public Address(String city, String country){
            this.country = country;
            this.city = city;
        }
    }
}
