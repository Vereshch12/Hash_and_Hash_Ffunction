package PhoneBook;

import java.util.Objects;

import static PhoneBook.Main.phoneBook;

public class Person {

    private String name;
    private String phone;

    public static void checkNaming (String line){
        if (line == null || line.isEmpty() || line.isBlank()) throw new RuntimeException("Ошибка ввода имени или телефона" + "!");
    }

    public Person(String name, String phone) {
        checkNaming(name);
        checkNaming(phone);
        this.name = name;
        this.phone = phone;
        phoneBook.put(name, phone);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
