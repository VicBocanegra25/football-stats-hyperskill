package com.hyperskill.data_models;

public abstract class Person {
    private String firstName;
    private String lastname;

    public Person(){}
    public Person(String firstName, String lastname){
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }
}
