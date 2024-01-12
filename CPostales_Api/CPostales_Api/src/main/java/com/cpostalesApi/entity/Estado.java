package com.cpostalesApi.entity;


import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estados")
@Serdeable.Serializable
public class Estado {



    @Id
    @Column(name = "id_estados")
    private int id_estado;

    @Column(name = "estados")
    private String estado;

    @Column(name = "abreviacion_Estados")
   private String EDO1;
}
