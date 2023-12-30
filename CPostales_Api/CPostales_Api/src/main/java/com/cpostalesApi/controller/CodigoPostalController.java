package com.cpostalesApi.controller;


import com.cpostalesApi.Service.CodigoPostalService;
import com.cpostalesApi.entity.CodigoPostal;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Controller("/api/v1")
public class CodigoPostalController {

    CodigoPostalService codigoPostalService;
    ColoniaController coloniaController;

    public CodigoPostalController (CodigoPostalService codigoPostalService, ColoniaController coloniaController){
        this.codigoPostalService=codigoPostalService;
        this.coloniaController=coloniaController;
    }

    @Get("/codigo_postal/{cp}")
    public List<String> showCodigoPostal (@PathVariable String cp){
        return coloniaController.show(cp);

    }


}
