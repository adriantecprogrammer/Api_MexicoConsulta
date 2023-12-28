package com.cpostalesApi.Service;

import com.cpostalesApi.entity.Colonia;
import com.cpostalesApi.entity.Municipio;
import com.cpostalesApi.repository.MunicipioRepository;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton

public class MunicipioService {
    MunicipioRepository municipioRepository;
    List<Municipio> municipios;

    public MunicipioService(MunicipioRepository municipioRepository, List<Municipio>municipios){
        this.municipioRepository=municipioRepository;
        this.municipios=municipios;
    }

    public List<Municipio> showMunicipios(int id_estados){
     return municipioRepository.findMunicipios(id_estados);

    }

}
