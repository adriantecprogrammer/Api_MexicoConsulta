package com.cpostalesApi.entity;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.ast.tree.expression.Distinct;

import java.io.Serializable;

@Entity
@Introspected
@Serdeable.Serializable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "municipios")
@ToString
@Builder


public class Municipio implements Serializable {


    @Id
    @Column(name = "id_municipio")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_municipios;

    @Column(name = "municipios")
    private String municipios;

    @ManyToOne
    @JoinColumn(name="id_estados")
    private Estado estado;



}
