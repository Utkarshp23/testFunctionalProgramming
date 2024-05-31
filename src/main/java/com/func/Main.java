package com.func;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> personList = List.of(
            new Person("Utkarsh",Gender.MALE),
            new Person("Abc",Gender.FEMALE),
            new Person("Xyz",Gender.FEMALE),
            new Person("Mno",Gender.FEMALE),
            new Person("Pqr",Gender.MALE)
        );

        //Declarative Approach
        personList.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .forEach(System.out::println);

        List<Person> femaleList = personList.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .toList();
        System.out.println("@@@--->"+femaleList);
    }


    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE
    }

}