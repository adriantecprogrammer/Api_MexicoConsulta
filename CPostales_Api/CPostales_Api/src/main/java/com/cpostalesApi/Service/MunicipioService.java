package com.cpostalesApi.Service;

import com.cpostalesApi.entity.Colonia;
import com.cpostalesApi.entity.Municipio;
import com.cpostalesApi.repository.MunicipioRepository;
import io.micronaut.data.annotation.Query;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Set;

@Singleton

public class MunicipioService {
    MunicipioRepository municipioRepository;


    public MunicipioService(MunicipioRepository municipioRepository){
        this.municipioRepository=municipioRepository;

    }

    public Set<Municipio> listAllById(Integer id) {
        return municipioRepository.findEstadoById(id);
    }

    public List<Municipio> findM(){
        return municipioRepository.findAll();
    }
}
