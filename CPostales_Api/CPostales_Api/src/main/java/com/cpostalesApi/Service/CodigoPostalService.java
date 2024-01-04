package com.cpostalesApi.Service;

import com.cpostalesApi.entity.CodigoPostal;
import com.cpostalesApi.entity.Colonia;
import com.cpostalesApi.repository.CodigoPostalRepository;
import com.cpostalesApi.repository.ColoniaRepository;
import jakarta.inject.Singleton;

import java.util.Set;

@Singleton
public class CodigoPostalService {

    ColoniaRepository coloniaRepository;

    public CodigoPostalService(ColoniaRepository coloniaRepository){
        this.coloniaRepository=coloniaRepository;
    }

    public Set<Colonia> findColoniasById(String id){
        return coloniaRepository.findColoniasById(id);
    }
}
