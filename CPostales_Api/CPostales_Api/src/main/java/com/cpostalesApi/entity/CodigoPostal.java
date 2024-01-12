package com.cpostalesApi.entity;


import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Serdeable.Serializable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "codigos_postales")
@ToString
public class CodigoPostal {

    @Id
    @Column(name = "cp")
    public String cp;

    @ManyToOne
    @JoinColumn(name="id_municipio")
    private Municipio municipio;

    /*
    @Column(name = "id_municipio")
    private int  id_municipio;

     */
}
