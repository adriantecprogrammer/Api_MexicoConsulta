package com.cpostalesApi.payload;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

    @Data
    @ToString
    @Builder
    @Serdeable.Serializable
    public class MensajeResponse implements Serializable {
        private Boolean error;
        private String mensaje;
        private Object object;

    }

