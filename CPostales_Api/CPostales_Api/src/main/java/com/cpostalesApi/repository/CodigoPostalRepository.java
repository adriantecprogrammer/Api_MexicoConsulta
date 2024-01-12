package com.cpostalesApi.repository;

import com.cpostalesApi.entity.CodigoPostal;
import com.cpostalesApi.entity.Colonia;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.repository.PageableRepository;

import java.util.List;
import java.util.Set;

@Repository
public interface CodigoPostalRepository extends PageableRepository<CodigoPostal, String> {




}
