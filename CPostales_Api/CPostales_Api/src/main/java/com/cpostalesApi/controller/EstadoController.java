package com.cpostalesApi.controller;

import com.cpostalesApi.Service.EstadoService;
import com.cpostalesApi.Service.MunicipioService;
import com.cpostalesApi.dto.MunicipioDTO;
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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Serdeable.Serializable
@Controller("/api/v1")
public class EstadoController {

    EstadoService estadoService;
    MunicipioService municipioService;
    HttpResponse<MensajeResponse> HttpResponse;
    MensajeResponse mensajeResponse;

    public EstadoController (EstadoService estadoService, MunicipioService municipioService){
        this.estadoService=estadoService;
        this.municipioService=municipioService;
    }

    @Get("/estado/{id_estado}")
    public Estado showById(@PathVariable int id_estado){
       return estadoService.showById(id_estado);
    }
    @Get("/saludar")
    public String saludar(){
        return "feliz navidad";
    }

    @Get("/estados")
    public List<Estado> showAll(){
        return estadoService.showAll();
    }

    @Get("/municipios/estado/{id}")
    @Status(HttpStatus.OK)
    public HttpResponse<?> mostrarMcpios(@PathVariable Integer id){
        try {
            Set<Municipio> listMunicipios=municipioService.listAllById(id);
            List<MunicipioDTO> municipiosDTO = listMunicipios.stream()
                    .map(municipio -> MunicipioDTO.builder()
                            .id_estados(municipio.getEstado().getId_estado())
                            .id_municipios(municipio.getId_municipios())
                            .municipio(municipio.getMunicipio())
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

}
