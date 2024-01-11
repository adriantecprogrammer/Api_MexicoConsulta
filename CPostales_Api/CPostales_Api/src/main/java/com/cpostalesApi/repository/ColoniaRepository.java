package com.cpostalesApi.repository;

import com.cpostalesApi.entity.Colonia;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import org.hibernate.annotations.Parameter;

import java.util.List;
import java.util.Set;

@Repository
public interface ColoniaRepository extends JpaRepository<Colonia,String> {

    @Query("SELECT m FROM Colonia m JOIN FETCH m.codigoPostal WHERE m.codigoPostal.cp = :id")
    Set<Colonia> findColoniasById(String id);

    @Query("SELECT m FROM Colonia m JOIN FETCH m.codigoPostal WHERE m.codigoPostal.municipio.id_municipios= :id AND m.codigoPostal.municipio.estado.id_estado =:id2")
    List<Colonia> findColoniasCE(  int id, int id2);


}
