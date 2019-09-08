package Entities;

import org.apache.commons.lang3.RandomStringUtils;

public class User {

    private static String firstName;
    private static String lastName;
    private static String phone;
    private static String email;
    private static String password;

    public User() {
    }

    public static String generateFirstName(int count) {
        return setFirstName(RandomStringUtils.randomAlphabetic(count));
    }

    public static String generateLastName(int count) {
        return setLastName(RandomStringUtils.randomAlphabetic(count));
    }

    public static String generatePhone(int count) {
        return setPhone(RandomStringUtils.randomNumeric(count));
    }

    public static String generateEmail(int count) {
        if (count == 0) return "";
        return setEmail(RandomStringUtils.randomAlphanumeric(count) + "@gmail.com");
    }

    public static String generateEmail(String str) {
        return setEmail(str);
    }

    public static String generatePassword(int count) {
        return setPassword(RandomStringUtils.randomAlphabetic(count));
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String setFirstName(String firstName) {
        User.firstName = firstName;
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String setLastName(String lastName) {
        User.lastName = lastName;
        return lastName;
    }

    public static String getPhone() {
        return phone;
    }

    public static String setPhone(String phone) {
        User.phone = phone;
        return phone;
    }

    public static String getEmail() {
        return email;
    }

    public static String setEmail(String email) {
        User.email = email;
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String setPassword(String password) {
        User.password = password;
        return password;
    }

    public static String enterSpecialCharacters() {
        return "!@#$%^&*()_+=-|\\/?.,`";
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
