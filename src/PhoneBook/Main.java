package PhoneBook;


import java.util.HashMap;

public class Main {
    static HashMap<String, String> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        Person misha = new Person("Михаил", "89212345465");
        Person katya = new Person("Екатерина", "89212345465");
        Person nikolay = new Person("Николай", "89212345465");
        Person john = new Person("Джон", "89212345465");
        Person nikita = new Person("Никита", "89212345465");
        System.out.println(phoneBook);

    }
}
