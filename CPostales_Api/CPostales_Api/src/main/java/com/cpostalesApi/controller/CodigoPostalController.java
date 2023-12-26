package com.cpostalesApi.controller;


import com.cpostalesApi.Service.CodigoPostalService;
import com.cpostalesApi.entity.CodigoPostal;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller("/api/v1")
public class CodigoPostalController {

    CodigoPostalService codigoPostalService;

    public CodigoPostalController (CodigoPostalService codigoPostalService){
        this.codigoPostalService=codigoPostalService;
    }

    @Get("/codigo_postal/{cp}")
    public CodigoPostal showCodigoPostal (@PathVariable String cp){
        return codigoPostalService.showCodigoPostal(cp);

    }

    @Get("/codigo_postal/saludar")
    public String saludarC(){
        return "HOLAAACPPP";
    }
}
