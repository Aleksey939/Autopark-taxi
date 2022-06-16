package org.ivanov.domains.entities;

import lombok.Data;


import javax.persistence.*;

import java.time.LocalDateTime;


@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private String startDate;
//    @Transient
//    private String startDateDto;
    private double sum;
    @Column(columnDefinition = "timestamp")
    private LocalDateTime time;
    @ManyToOne(optional = false)
    private Person person;
//    @OneToOne(optional = false)
//    private Coming coming;







}
