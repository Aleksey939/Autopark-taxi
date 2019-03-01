package org.ivanov.Domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class WorkDone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Date;
    private Integer  mileage;
    private String name;
    private String description;
    @Column(columnDefinition = "timestamp")
    private LocalDateTime time;
    private BigDecimal price;
    private Boolean done;
    @ManyToOne(optional = false)
    private Car car;
}
