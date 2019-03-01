package org.ivanov.Domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private BigDecimal sum;
    @Column(columnDefinition = "timestamp")
    private LocalDateTime time;
    @ManyToOne(optional = false)
    private Person person;







}
