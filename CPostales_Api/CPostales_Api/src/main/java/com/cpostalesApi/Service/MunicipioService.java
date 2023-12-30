package com.cpostalesApi.Service;

import com.cpostalesApi.entity.Colonia;
import com.cpostalesApi.entity.Municipio;
import com.cpostalesApi.repository.MunicipioRepository;
import io.micronaut.data.annotation.Query;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton

public class MunicipioService {
    MunicipioRepository municipioRepository;


    public MunicipioService(MunicipioRepository municipioRepository){
        this.municipioRepository=municipioRepository;

    }

    public List<Municipio> showMunicipios(int id_estados){
     List<Municipio>municipios = municipioRepository.findMunicipios(id_estados);

     return municipios;

    }
    /*
    public List<String>show(int id_estados){
        return municipioRepository.findM(id_estados);
    }

     */

}
