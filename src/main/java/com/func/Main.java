package com.func;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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

        //Funcions
        int mod = findModulo.apply(6);
        System.out.println("@@@--->Mod: "+mod);

        //BiFunctions
        int finalAnswer = findModulo.andThen(increament).apply(6);
        System.out.println("@@@---ght:"+finalAnswer);

        //Consumer
        Person p = new Person("Utkarsh", Gender.MALE);
        greetPersonConsumer.accept(p);

        //BiConsumer
        greetConsumerIfMale.accept(p,true);

        //Predicate
        System.out.println(isMale.test(Gender.MALE));


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

    static Function<Integer,Integer> findModulo = number -> number%2;

    static Function<Integer,Integer> increament = number -> number+1;

    //Consumer
    static Consumer<Person> greetPersonConsumer = person -> System.out.println("Hello "+person.name);

    //BiConsumer
    static BiConsumer<Person,Boolean> greetConsumerIfMale = (person, aBoolean) -> System.out.println("Hello "+(aBoolean ? person.name : "*****"));

    //Predicate
    static Predicate<Gender> isMale =  gender -> gender.equals(Gender.MALE);
}