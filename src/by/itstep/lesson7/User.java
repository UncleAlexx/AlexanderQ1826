package by.itstep.lesson7;

import java.util.Objects;

public class User implements Comparable<User> {
    public String name;
    public Sex sex;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }

    public int age = 0;

    public User(String name, Sex sex, int age){
        this.sex = sex;
        this.name = name;
        setAge(age);
    }

    @Override
    public int compareTo(User o) {
        if(o == null)
            throw new NullPointerException();
        if(age == o.age){
            if(name == null || o.name == null)
                throw new NullPointerException();
            if(name.length() != o.name.length())
                return name.length() > o.name.length()? 1 : -1;
            for (int i = 0; i < name.length(); i++){
                if(name.charAt(i) != o.name.charAt(i))
                    return name.charAt(i) > o.name.charAt(i)? 1 : -1;
            }
            return 0;
        }
        return age > o.age? 1 : -1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0 && age < 120)
            this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
