package com.cpostalesApi.dto;

import com.cpostalesApi.entity.Colonia;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Serdeable.Serializable
public class CodigoPostalDTO {

    public String cp;
    private Integer id_estados;
    private String id_municipios;
    private String estado;
    private String municipio;
    private Colonia colonia ;

}
