package com.cpostalesApi.controller;

import com.cpostalesApi.Service.ColoniaService;
import com.cpostalesApi.entity.Colonia;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;

@Controller("/api/v1")
public class ColoniaController {
    ColoniaService coloniaService;

    public ColoniaController(ColoniaService coloniaService){
        this.coloniaService=coloniaService;
    }

    /*
    @Get("/colonia/{cp}")
    public Colonia showColonia(@PathVariable String cp){

        return coloniaService.showColonia(cp);
    }


     */
    @Get("/colonias/{cp}")
    public List<Colonia> showColoniaByCodigoPostal(@PathVariable String cp){
         return coloniaService.getColoniasByCodigoPostal(cp);
    }
}
