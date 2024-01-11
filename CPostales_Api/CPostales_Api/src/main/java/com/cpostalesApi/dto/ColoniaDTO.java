package com.cpostalesApi.dto;


import com.cpostalesApi.entity.Estado;
import com.cpostalesApi.entity.Municipio;
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
public class ColoniaDTO {

    private String colonia;
    private String cp;
    private Municipio municipio;
    private Estado estado;

}
