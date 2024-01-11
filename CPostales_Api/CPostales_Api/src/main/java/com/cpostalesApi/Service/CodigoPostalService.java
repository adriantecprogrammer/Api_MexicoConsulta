package com.cpostalesApi.Service;

import com.cpostalesApi.entity.CodigoPostal;
import com.cpostalesApi.entity.Colonia;
import com.cpostalesApi.repository.CodigoPostalRepository;
import com.cpostalesApi.repository.ColoniaRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Set;

@Singleton
public class CodigoPostalService {

    ColoniaRepository coloniaRepository;
    CodigoPostalRepository codigoPostalRepository;

    public CodigoPostalService(ColoniaRepository coloniaRepository, CodigoPostalRepository codigoPostalRepository){
        this.coloniaRepository=coloniaRepository;
        this.codigoPostalRepository=codigoPostalRepository;
    }

    public Set<Colonia> findColoniasById(String id){
        return coloniaRepository.findColoniasById(id);
    }


public CodigoPostal cp(String id){
    return codigoPostalRepository.findById(id).orElse(null);
}

    public List<CodigoPostal> findAllCP(){
        return codigoPostalRepository.findAll();
    }
    public List<Colonia> findColoniasCE(int id_municipio, int id_estado){
        return coloniaRepository.findColoniasCE(id_municipio,id_estado);
    }
}
