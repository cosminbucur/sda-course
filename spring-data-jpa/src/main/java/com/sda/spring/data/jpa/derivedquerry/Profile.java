package com.sda.spring.data.jpa.derivedquerry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Table(name = "profile")
@Entity
public class Profile {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private ZonedDateTime birthDate;
    private Boolean active;

    public Profile() {
    }

    public Profile(String name, Integer age, ZonedDateTime birthDate, Boolean active) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ZonedDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(ZonedDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
