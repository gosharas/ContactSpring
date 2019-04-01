package ru.spring.project.model;

import lombok.*;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@AllArgsConstructor автоматически создает констр-ор класса со всеми аргументами
//@NoArgsConstructor автоматически создает пустой конструктор класса со всеми аргументами
//@Data создает toString, equals, hashCode, getters, setters.


@Getter
@Setter
@ToString
@MappedSuperclass
public class BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
