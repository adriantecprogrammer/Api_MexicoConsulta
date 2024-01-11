package com.cpostalesApi.controller;


import com.cpostalesApi.Service.CodigoPostalService;
import com.cpostalesApi.Service.ColoniaService;
import com.cpostalesApi.dto.CodigoPostalDTO;
import com.cpostalesApi.dto.ColoniaDTO;
import com.cpostalesApi.dto.MunicipioDTO;
import com.cpostalesApi.entity.CodigoPostal;
import com.cpostalesApi.entity.Colonia;
import com.cpostalesApi.entity.Municipio;
import com.cpostalesApi.payload.MensajeResponse;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Status;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller("/api/v1")
public class CodigoPostalController {

    CodigoPostalService codigoPostalService;
    ColoniaController coloniaController;
    ColoniaService coloniaService;
    MensajeResponse mensajeResponse;
    HttpResponse<MensajeResponse> HttpResponse;

    public CodigoPostalController (CodigoPostalService codigoPostalService, ColoniaController coloniaController, ColoniaService coloniaService){
        this.codigoPostalService=codigoPostalService;
        this.coloniaController=coloniaController;
        this.coloniaService=coloniaService;
    }


    @Get("/colonias/codigo_postal/{id}")
    @Status(HttpStatus.OK)
    public HttpResponse<?> mostrarColonias(@PathVariable String id){
        try {
            Set<Colonia> listColonias=codigoPostalService.findColoniasById(id);
            List<ColoniaDTO> coloniasDTO = listColonias.stream()
                    .map(colonia -> ColoniaDTO.builder().colonia(colonia.getColonia()).cp(colonia.getCodigoPostal().cp)
                            .build())
                    .collect(Collectors.toList());
            if (listColonias==null){

                mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron colonias").object(null).build();
                return io.micronaut.http.HttpResponse.notFound(mensajeResponse);

            }else{
                int tamaño= coloniasDTO.size();
                mensajeResponse= MensajeResponse.builder().error(true).mensaje("Colonias encontrados: "+tamaño).object(coloniasDTO).build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);

            }
        }catch (Exception exDt){
            mensajeResponse=  MensajeResponse.builder().error(true).mensaje(exDt.getMessage()).object(null).build();
            return io.micronaut.http.HttpResponse.notFound(mensajeResponse);

        }
    }

    @Get("/municipio/{id_municipio}/estado/{id_estado}/colonias")
    public HttpResponse<?> findColoniasCE(int id_municipio, int id_estado){
        List<Colonia> listaColonias= codigoPostalService.findColoniasCE(id_municipio,id_estado);
        List<ColoniaDTO> coloniaDTO;
        coloniaDTO=listaColonias.stream().map(colonia -> ColoniaDTO.builder()
                .colonia(colonia.getColonia())
                .cp(colonia.getCodigoPostal().getCp())
                .municipio(colonia.getCodigoPostal().getMunicipio()).build()).collect(Collectors.toList());

        if (listaColonias==null){

            mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron colonias").object(null).build();
            return io.micronaut.http.HttpResponse.notFound(mensajeResponse);

        }else{
            int tamaño= coloniaDTO.size();
            mensajeResponse= MensajeResponse.builder().error(true).mensaje("Colonias encontrados: "+tamaño).object(coloniaDTO).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);

        }
    }


    @Get("/codigos")
    public List<CodigoPostal> findAllCP(){
        return codigoPostalService.findAllCP();
    }
    @Get("/cp/{id}")

    public CodigoPostal cp(String id){
        return codigoPostalService.cp(id);
    }


}
