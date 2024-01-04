package com.cpostalesApi.repository;

import com.cpostalesApi.entity.CodigoPostal;
import com.cpostalesApi.entity.Colonia;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Set;

@Repository
public interface CodigoPostalRepository extends JpaRepository<CodigoPostal, String> {

}
