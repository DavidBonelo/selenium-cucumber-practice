package com.davidbonelo.models;

import net.datafaker.Faker;

import java.util.Locale;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String salary;
    private String department;

    public static Employee createFakeEmployee() {
        Faker faker = new Faker(new Locale("es"));
        Employee employee = new Employee();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setEmail(faker.internet().emailAddress());
        employee.setAge(faker.number().numberBetween(18, 100));
        employee.setSalary(faker.bothify("####"));
        employee.setDepartment(faker.commerce().department());
        return employee;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee e = (Employee) o;
        return Objects.equals(firstName, e.firstName) && Objects.equals(lastName, e.lastName) && Objects.equals(email, e.email) && Objects.equals(age, e.age) && Objects.equals(salary, e.salary) && Objects.equals(department, e.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, age, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary='" + salary + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
