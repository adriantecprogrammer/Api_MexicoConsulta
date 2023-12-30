package com.cpostalesApi.repository;

import com.cpostalesApi.entity.Colonia;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import org.hibernate.annotations.Parameter;

import java.util.List;

@Repository
public interface ColoniaRepository extends JpaRepository<Colonia,String> {

    @Query("SELECT colonia  FROM Colonia  WHERE cp = :cp")
    List<Colonia> find(String cp);


   // List<Colonia> findAllByid(String id);

}
