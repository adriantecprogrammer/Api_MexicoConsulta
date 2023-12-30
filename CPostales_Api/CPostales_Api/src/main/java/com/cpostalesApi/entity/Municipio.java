package com.cpostalesApi.entity;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.sql.ast.tree.expression.Distinct;

@Entity
@Introspected
@Serdeable.Serializable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "municipios")
@ToString


public class Municipio {
    /*

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estados")
    private Estado estado;

     */

    @Column(name = "id_municipios")
    private String id_municipios;

    @Column(name = "municipio")
    private String municipio;


    @Id
    @Column(name = "id_estados")
    private int id_estados;

}
