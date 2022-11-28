package Passport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static Passport.Main.listOfPassports;

public class Passport {

    private Integer number;
    private String surname;
    private String name;
    private String patronymic;
    private String dateOfBirthday;

    private boolean checkNaming (String line){
        return (line == null || line.isEmpty() || line.isBlank());
    }

    private static Date parseDate(String date){
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public Passport(Integer number, String surname, String name, String patronymic, String dateOfBirthday) {
        if (number <= 0) throw new RuntimeException("Неверно введен номер паспорта");
        if (checkNaming(surname)) throw new RuntimeException("Неверно введена фамимлия!");
        if (checkNaming(name)) throw new RuntimeException("Неверно введено имя!");
        if (checkNaming(patronymic)) patronymic = "Отсутствует";
        this.number = number;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        if (parseDate(dateOfBirthday) == null) throw new RuntimeException("Дата должна быть введена в формате dd.MM.yyyy");
        this.dateOfBirthday = dateOfBirthday;
    }

    public void addPassport(){
        for (Passport passport: listOfPassports){
            if (passport.equals(this)){
                passport.name = this.name;
                passport.surname = this.surname;
                passport.patronymic = this.patronymic;
                passport.dateOfBirthday = this.dateOfBirthday;
                return;
            }
        }
        listOfPassports.add(this);
    }


    public Integer getNumber() {
        return number;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(number, passport.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, surname, name, patronymic, dateOfBirthday, listOfPassports);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "number=" + number +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirthday='" + dateOfBirthday + '\'' +
                '}';
    }
}
