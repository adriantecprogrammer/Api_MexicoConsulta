package com.cpostalesApi.repository;

import com.cpostalesApi.entity.Municipio;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.sql.ResultSet;
import java.util.List;

@Repository

public interface MunicipioRepository extends JpaRepository<Municipio,Integer>{

     //este si muestra los objetos pero se repite el primero
    //@Query("SELECT m FROM  Municipio m WHERE m.id_estados = :id ")

    @Query(value = "SELECT DISTINCT m.* FROM Municipios m WHERE m.id_estados = :id", nativeQuery = true)
     List<Municipio>findMunicipios(Integer id);

    /*
    @Query("SELECT municipio FROM Municipio where id_estados=:id ") //este solo imprime strings pero todos los elementos
    List<String>findM(Integer id);

     */
}
