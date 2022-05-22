package org.ivanov.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private Integer engineСapacity;
    private String transmission;



   @OneToMany(mappedBy = "brand",fetch = FetchType.EAGER)
   private Collection<Car> cars;


}
