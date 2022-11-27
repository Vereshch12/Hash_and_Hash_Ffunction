package Passport;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Passport> listOfPassports = new ArrayList<Passport>();

    public static void printAllPassports() {
        System.out.println("|№           |Фамилия       |Имя           |Отчество      |Дата рождения |");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        for (Passport passport: listOfPassports){
            System.out.printf("|%-12d|%-14s|%-14s|%-14s|%-14s|\n", passport.getNumber(), passport.getSurname(), passport.getName(), passport.getPatronymic(), passport.getDateOfBirthday());
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        }
    }

    public static Passport searchPassport(Integer number){
        for (Passport passport: listOfPassports){
            if (passport.getNumber().equals(number)){
                return passport;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Passport person1 = new Passport(123,"abc","abc","","12.07.2003");
        person1.addPassport();
        printAllPassports();
        Passport person2 = new Passport(1234,"abcde","abcde","de","15.07.2003");
        person2.addPassport();
        printAllPassports();
        Passport person3 = new Passport(1234,"a","abcde","de","15.07.2003");
        person3.addPassport();
        printAllPassports();
        Passport person4 = new Passport(12345,"a","abcde","de","15.07.2003");
        person4.addPassport();
        printAllPassports();
        System.out.println(searchPassport(12345));
    }
}