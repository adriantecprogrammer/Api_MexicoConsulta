package com.cpostalesApi.controller;

import com.cpostalesApi.Service.CodigoPostalService;
import com.cpostalesApi.Service.EstadoService;
import com.cpostalesApi.Service.MunicipioService;
import com.cpostalesApi.dto.ColoniaDTO;
import com.cpostalesApi.dto.MunicipioDTO;
import com.cpostalesApi.entity.CodigoPostal;
import com.cpostalesApi.entity.Colonia;
import com.cpostalesApi.entity.Estado;
import com.cpostalesApi.entity.Municipio;
import com.cpostalesApi.payload.MensajeResponse;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Status;
import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Serdeable.Serializable
@Controller("/api/v1")
public class EstadoController {

    EstadoService estadoService;
    MunicipioService municipioService;
    CodigoPostalService codigoPostalService;
    HttpResponse<MensajeResponse> HttpResponse;
    MensajeResponse mensajeResponse;

    public EstadoController (EstadoService estadoService, MunicipioService municipioService, CodigoPostalService codigoPostalService){
        this.estadoService=estadoService;
        this.municipioService=municipioService;
        this.codigoPostalService=codigoPostalService;
    }



    @Get("/estado/{id_estado}")
    @Operation(summary = "Obtener información de un estado en especifico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @Status(HttpStatus.OK)
    public HttpResponse<?> showById(@PathVariable int id_estado){

        return io.micronaut.http.HttpResponse.ok( estadoService.showById(id_estado));

    }

    @Get("/estados")
    @Operation(summary = "Obtener información de todos los estados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @Status(HttpStatus.OK)
    public HttpResponse<?> showAll(){
       List<Estado> estados= estadoService.showAll();

       int tamaño = estados.size()+1;
       if(estados!=null){
           mensajeResponse=MensajeResponse.builder().error(false).mensaje("Estados encontrados: "+tamaño).object(estados).build();

           return io.micronaut.http.HttpResponse.ok(mensajeResponse);
       }else{
           mensajeResponse=MensajeResponse.builder().error(true).mensaje("Estados no encontrados").object(estados).build();
           return io.micronaut.http.HttpResponse.notFound(mensajeResponse);
       }


    }

    @Get("/municipios/estado/{id}")
    @Operation(summary = "Obtener todos los municipios de un estado por medio de el id del estado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @Status(HttpStatus.OK)
    public HttpResponse<?> mostrarMcpios(@PathVariable Integer id){
        try {
            Set<Municipio> listMunicipios=municipioService.listAllById(id);
            List<MunicipioDTO> municipiosDTO = listMunicipios.stream()
                    .map(municipio -> MunicipioDTO.builder()
                            .id_estados(municipio.getEstado().getId_estado())
                            .id_municipios(String.valueOf(municipio.getId_municipios()))
                            .municipio(municipio.getMunicipios())
                            .build())
                    .collect(Collectors.toList());
            if (listMunicipios==null){

               mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron municipios").object(null).build();
                return io.micronaut.http.HttpResponse.notFound(mensajeResponse);

            }else{
                int tamaño= municipiosDTO.size();
                 mensajeResponse= MensajeResponse.builder().error(true).mensaje("Municipios encontrados: "+tamaño).object(municipiosDTO).build();
                 return io.micronaut.http.HttpResponse.ok(mensajeResponse);

            }
        }catch (Exception exDt){
               mensajeResponse=  MensajeResponse.builder().error(true).mensaje(exDt.getMessage()).object(null).build();
               return io.micronaut.http.HttpResponse.notFound(mensajeResponse);

        }
    }


    @Get("/colonias/codigo_postal/{id}")

    @Operation(summary = "Obtener todas las colonias de un codigo postal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
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
    @Operation(summary = "Obtener todas las colonias usando el id de el municipio y del estado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
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


    @Operation(summary = "Obtener todos los codigos postales del pais")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })
    @Get("/codigos")
    @Status(HttpStatus.OK)
    public List<CodigoPostal> findAllCP(){
        return codigoPostalService.findAllCP();
    }


    @Get("/cp/{id}")
    @Operation(summary = "Obtener informacion de un codigo postal usando al codigo postal como id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    })

    public CodigoPostal cp(String id){
        return codigoPostalService.cp(id);
    }

}
