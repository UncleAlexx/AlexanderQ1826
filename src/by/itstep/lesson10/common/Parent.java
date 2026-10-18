package by.itstep.lesson10.common;

import java.util.List;
import java.util.Objects;

public class Parent {
    private String name;
    private Integer age;
    private List<Child> children;

    public Parent(String name, Integer age, List<Child> children) {
        this.name = name;
        this.age = age;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", children=" + children +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(name, parent.name) && Objects.equals(age, parent.age) && Objects.equals(children, parent.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, children);
    }
}
