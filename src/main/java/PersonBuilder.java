public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if ((age < 0) || (age > 200)) {
            throw new IllegalArgumentException("Возраст задан не корректно.");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException, IllegalArgumentException {
        if ((name == null)
                || (name == "")
                || (surname == null)
                || (surname == "")) {
            throw new IllegalStateException("Не все обязательные поля заполнены");
        }
        Person p = new Person(name, surname);
        if (age != -1) {
            p.setAge(age);
        }
        if ((address != null) || (address != "")) {
            p.setAddress(address);
        }
        return p;
    }
}