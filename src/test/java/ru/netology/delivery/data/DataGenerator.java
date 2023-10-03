package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] city = {"Москва", "Тверь", "Пермь", "Нижний Новгород", "Севастополь", "Йошкар-Ола"};
        return city[new Random().nextInt(city.length - 1)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String lastName = faker.name().lastName();
        String firstName = faker.name().firstName();
        return lastName + " " + firstName;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }
}
