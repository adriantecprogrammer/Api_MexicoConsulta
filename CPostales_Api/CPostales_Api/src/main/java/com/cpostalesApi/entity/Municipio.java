package com.cpostalesApi.entity;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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


public class Municipio implements Serializable {

    /*
    @ManyToOne
    @Id
    @JoinColumn(name = "id_estados")
    private Estado estados;

     */
@Id
@Column(name = "id_estados")
private int id_estados;

    @Column(name = "id_municipios")
    private String id_municipios;

    @Column(name = "municipio")
    private String municipio;


    //@Column(name = "id_estados")
   // private int id_estados;


}
