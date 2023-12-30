package com.cpostalesApi.controller;


import com.cpostalesApi.Service.MunicipioService;
import com.cpostalesApi.entity.Municipio;
import io.micronaut.data.annotation.Query;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/api/v1")
public class MunicipioController {

MunicipioService municipioService;

public MunicipioController(MunicipioService municipioService){
    this.municipioService=municipioService;
}

@Get("/municipios/{id_estados}")

public List<Municipio> showMunicipios (int id_estados){
    return municipioService.showMunicipios(id_estados);
}

/*
@Get("/mun/{id_estados}")
public List<String>show(int id_estados){
    return municipioService.show(id_estados);
}

 */

}
