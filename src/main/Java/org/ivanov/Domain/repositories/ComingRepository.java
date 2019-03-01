package org.ivanov.Domain.repositories;

import org.ivanov.Domain.entity.Car;
import org.ivanov.Domain.entity.Coming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComingRepository extends JpaRepository<Coming, Integer> {

   // Coming findByCarOrderByIdDesc(String Car);
   Coming findByCarId(Integer CarId);

    //@Query("Select c from coming where c.id<:id")
    //Coming mymethod(@Param("id") Integer id);//найти первый перед ID
    //Coming findTop1LessThenId(Integer id);// findTop3ByCompanyOrderByName найти первый перед ID

    public List<Coming> findAllByCar(Car Car);
}
