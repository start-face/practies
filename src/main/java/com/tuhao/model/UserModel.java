package com.tuhao.model;

import com.google.common.base.MoreObjects;

/**
 * 用户实体
 * @author FaceFeel
 * @create 2017-09-08 12:33
 */

public class UserModel implements java.io.Serializable {

    private String id;
    private String name;
    private String age;
    private String passWord;

    public UserModel() {
        super();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("age", age)
                .add("passWord", passWord)
                .toString();
    }

    public String getId() {
        return id;
    }

    public UserModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public UserModel setAge(String age) {
        this.age = age;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public UserModel setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }
}
