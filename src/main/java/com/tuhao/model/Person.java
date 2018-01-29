package com.tuhao.model;

import com.belerweb.social.bean.Gender;
import com.google.common.base.MoreObjects;

public class Person {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private String eMail;
    private String phone;
    private String address;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("givenName", givenName)
                .add("surName", surName)
                .add("age", age)
                .add("gender", gender)
                .add("eMail", eMail)
                .add("phone", phone)
                .add("address", address)
                .toString();
    }

    public String getGivenName() {
        return givenName;
    }

    public Person setGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public String getSurName() {
        return surName;
    }

    public Person setSurName(String surName) {
        this.surName = surName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String geteMail() {
        return eMail;
    }

    public Person seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Person setAddress(String address) {
        this.address = address;
        return this;
    }
}
