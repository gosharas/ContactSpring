package ru.spring.project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "contact")
public class Contact extends BasicEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "address")
    private String address;
}
