package com.cpostalesApi.Service;


import com.cpostalesApi.entity.Colonia;
import com.cpostalesApi.repository.ColoniaRepository;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ColoniaService {
    ColoniaRepository coloniaRepository;

    public ColoniaService(ColoniaRepository coloniaRepository){
        this.coloniaRepository=coloniaRepository;
    }

    public Colonia showColonia(String cp){
        return coloniaRepository.findById(cp).orElse(null);
    }
    public List <Colonia> getColoniasByCodigoPostal(String cp) {

       return coloniaRepository.find(cp);

    }
}
