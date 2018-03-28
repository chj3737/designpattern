package com.chj.designpattern;

import lombok.Getter;
import lombok.NonNull;

@Getter
class Person {
    @NonNull  private String firstName;
    private String lastName;
    private int age;
    // extra properties;

    public void sayHi() {
        System.out.println("my name is " + firstName + " " + lastName + ", age: " + age);
    }

    static class PersonBuilder {
        private Person person = new Person();
        public PersonBuilder(String lastName) {
            person.lastName = lastName;
        }

        public PersonBuilder firstName(String firstName) {
            person.firstName = firstName;
            return this;
        }

        public PersonBuilder age(int age) {
            person.age = age;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder("chen")
                .firstName("hj")
                .age(10)
                .build();
        person.sayHi();
    }

}
