package com.cpostalesApi.Service;

import com.cpostalesApi.entity.CodigoPostal;
import com.cpostalesApi.repository.CodigoPostalRepository;
import jakarta.inject.Singleton;

@Singleton
public class CodigoPostalService {

    CodigoPostalRepository codigoPostalRepository;

    public CodigoPostalService(CodigoPostalRepository codigoPostalRepository){
        this.codigoPostalRepository=codigoPostalRepository;
    }

    public CodigoPostal showCodigoPostal(String cp){
        return codigoPostalRepository.findById(cp).orElse(null);
    }
}
