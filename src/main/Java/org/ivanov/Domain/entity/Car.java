package org.ivanov.Domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private Integer mileage;
    private Integer year;
    private Integer priceStart;
    private Integer priceEnd;

    @ManyToOne(optional = false)
    private Person person;

    @ManyToOne(optional = false)
    private Brand brand;

    @OneToMany(mappedBy = "car",fetch = FetchType.EAGER)
    private Collection<Coming> comings;


//    @OneToMany(mappedBy = "car",fetch = FetchType.EAGER)
//    private Collection<WorkDone> workdones;
}
