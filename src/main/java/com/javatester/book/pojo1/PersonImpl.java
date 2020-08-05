package com.javatester.book.pojo1;

import java.time.LocalDate;
import java.util.Objects;

public class PersonImpl implements Person{
    private String firstName;
    private String lastName;
    private LocalDate birthDate;


    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String s) {
        this.firstName = s;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String s) {
        this.lastName = s;
    }

    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Override
    public void setBirthDate(LocalDate d) {
        this.birthDate = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonImpl person = (PersonImpl) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate);
    }
}
