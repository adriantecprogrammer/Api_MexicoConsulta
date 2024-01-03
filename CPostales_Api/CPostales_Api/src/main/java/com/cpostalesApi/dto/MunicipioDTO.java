package com.cpostalesApi.dto;


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

public class MunicipioDTO {
    private int id_estados;

    private String id_municipios;

    private String municipio;
}
