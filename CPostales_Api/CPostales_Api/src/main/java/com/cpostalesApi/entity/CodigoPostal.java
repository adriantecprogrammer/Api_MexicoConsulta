package com.cpostalesApi.entity;


import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Serdeable.Serializable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "codigopostal")
@ToString
public class CodigoPostal {

    @Id
    @Column(name = "cp")
    public String cp;

    @Column(name = "id_municipios")
    public String id_municipios;
}
