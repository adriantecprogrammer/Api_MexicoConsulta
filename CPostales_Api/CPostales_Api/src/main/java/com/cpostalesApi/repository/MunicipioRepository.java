package com.cpostalesApi.repository;

import com.cpostalesApi.entity.Estado;
import com.cpostalesApi.entity.Municipio;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.repository.PageableRepository;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Parameter;


import java.util.List;
import java.util.Set;

@Repository

public interface MunicipioRepository extends JpaRepository<Municipio, String> {
    @Query("SELECT m FROM Municipio m JOIN FETCH m.estado WHERE m.estado.id_estado = :id")
    List<Municipio> findEstadoById(int id);

     //este si muestra los objetos pero se repite el primero
    //@Query("SELECT m FROM  Municipio m WHERE m.id_estados = :id ")

    @Query(value = "SELECT * FROM municipios  WHERE id_estados = :id", nativeQuery = true)

   // @Query("SELECT DISTINCT m FROM Municipio m JOIN FETCH m.estados WHERE m.estados.id_estado = :id")
    List<Municipio> findMunicipios(Integer id);


  //  @Query("SELECT municipio FROM Municipio where id_estados=:id ") //este solo imprime strings pero todos los elementos
   // List<String>findM(Integer id);


}
