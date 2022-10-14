public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ошибка! Введите имя.");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Ошибка! Введите фамилию.");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Ошибка! Возраст должен быть больше 0.");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || name.isBlank() || surname == null || surname.isBlank()) {
            throw new IllegalStateException("Ошибка! Не хватает обязательных полей.");
        }
        if (age < 0) {
            throw new IllegalStateException("Ошибка! Возраст должен быть больше 0");
        }
        person = new Person(this.name, this.surname, this.age);
        person.setCity(city);
        return person;
    }
}
