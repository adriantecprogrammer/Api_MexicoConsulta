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
@Table(name = "colonias")
@Serdeable.Serializable


public class Colonia {

    @Column(name = "colonia")
    private String colonia;

    @Id
    @Column(name = "cp")
    private String cp;

    public String toString(){
        return "Colonia: "+colonia+" Cp: "+cp;
    }


}
