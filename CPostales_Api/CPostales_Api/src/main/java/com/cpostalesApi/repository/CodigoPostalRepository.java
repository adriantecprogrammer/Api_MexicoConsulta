package com.cpostalesApi.repository;

import com.cpostalesApi.entity.CodigoPostal;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface CodigoPostalRepository extends JpaRepository<CodigoPostal, String> {

}
