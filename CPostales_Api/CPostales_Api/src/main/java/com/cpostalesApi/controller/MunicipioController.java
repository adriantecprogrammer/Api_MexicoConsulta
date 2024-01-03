package com.cpostalesApi.controller;


import com.cpostalesApi.Service.MunicipioService;
import com.cpostalesApi.entity.Municipio;
import io.micronaut.data.annotation.Query;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;
import java.util.Set;

@Controller("/api/v1")
public class MunicipioController {

MunicipioService municipioService;

public MunicipioController(MunicipioService municipioService){
    this.municipioService=municipioService;
}


}
