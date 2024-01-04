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
 List<String>col;

    public ColoniaController(ColoniaService coloniaService, List<String>col){
        this.coloniaService=coloniaService;
        this.col=col;
    }

}
