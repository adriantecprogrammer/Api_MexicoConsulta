package com.cpostalesApi.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

public class Payload {
    
    @Data
    @ToString
    @Builder
    public class MensajeResponse implements Serializable {
        private Boolean error;
        private String mensaje;
        private Object object;

    }
}
