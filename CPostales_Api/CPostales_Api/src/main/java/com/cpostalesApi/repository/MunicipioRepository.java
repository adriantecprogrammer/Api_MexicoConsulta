package com.cpostalesApi.repository;

import com.cpostalesApi.entity.Municipio;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;



import java.util.List;
import java.util.Set;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {
    @Query("SELECT m FROM Municipio m JOIN FETCH m.estado WHERE m.estado.id_estado = :id")
    Set<Municipio> findEstadoById(int id);




}
