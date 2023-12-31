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

    /*
    @OneToMany(mappedBy = "estados", fetch = FetchType.EAGER)
    private List<Municipio> municipios;

     */

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estados")
    private int id_estado;

    @Column(name = "estados")
    private String estado;
}
