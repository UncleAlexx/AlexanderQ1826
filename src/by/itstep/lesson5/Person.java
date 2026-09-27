package by.itstep.lesson5;

abstract class Person {

    private String name;
    private String surname;

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (String) getNewIfNotNull(this.name, name);
    }

    public void setSurname(String surname) {
        this.surname = (String) getNewIfNotNull(this.surname, surname);
    }

    public String getFullName(){
        return  """
        {
            "name" : "%s",
            "surname" : "%s"
        }
        """.formatted(name, surname);
    }

    private Object getNewIfNotNull(Object oldObj, Object newObj ) {
        return  newObj  == null? oldObj : newObj;
    }
}
