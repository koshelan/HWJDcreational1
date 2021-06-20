import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean setAge(int age) {
        if (!hasAge()) {
            this.age = age;
            return true;
        } else {
            System.out.println("Внести изменения не возможно возраст уже задан.");
            return false;
        }
    }

    public void happyBirthday() {
        if (hasAge()) {
            System.out.println("Возраст человека не известен, но поздравляемя с ДР.");
        } else {
            System.out.println("Поздравляю с " + (++this.age) + " летием");
        }
    }

    public boolean hasAge() {
        return this.age == -1 ? false : true;
    }

    public boolean hasAddress() {
        return (this.address == null) || (this.address == "") ? false : true;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name) &&
                surname.equals(person.surname) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        return "Person{\n" +
                "name = " + name + '\n' +
                "surname = " + surname + '\n' +
                "age = " + (hasAge() ? age : "Возраст не задан") + '\n' +
                "address = " + (hasAddress() ? address : "неизвестен") + '\n' +
                '}';
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAge(0).setAddress(address);
    }

}
