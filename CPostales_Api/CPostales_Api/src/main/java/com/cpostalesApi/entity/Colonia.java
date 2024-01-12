package com.cpostalesApi.entity;


import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "colonias")
@Serdeable.Serializable

public class Colonia {

    @Id
    @Column(name = "colonia")
    private String colonia;


    @ManyToOne
    @JoinColumn(name="cp")
    private CodigoPostal codigoPostal;

     /*
    @Column(name = "cp")
    private String cp;

      */

}
