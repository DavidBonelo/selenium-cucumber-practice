package com.davidbonelo.models;

import com.davidbonelo.models.enums.Gender;
import com.davidbonelo.models.enums.Hobby;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String phone;
    private LocalDate birthDate;
    private List<String> subjects;
    private List<Hobby> hobbies;
    private String address;
    private String state;
    private String city;

    public static Student createFakeStudent() {
        Student student = new Student();
        student.setFirstName("pepito");
        student.setLastName("perez");
        student.setEmail("a@a.com");
        student.setGender(Gender.MALE);
        student.setBirthDate(LocalDate.now().minusYears(27).minusDays(5));
        student.setPhone("1234567890");
        student.setSubjects(List.of("Maths", "Physics"));
        List<Hobby> hobbyList = new ArrayList<>();
        hobbyList.add(Hobby.MUSIC);
        hobbyList.add(Hobby.READING);
        student.setHobbies(hobbyList);
        student.setAddress("calle 123");
        student.setState("Haryana");
        student.setCity("Panipat");
        return student;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
