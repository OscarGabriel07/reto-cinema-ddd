package org.example.cinema.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (this.value.length() <= 2){
            throw new IllegalArgumentException("El nombre debe tener más de dos caracteres");
        }
        if (this.value.length() >= 100){
            throw new IllegalArgumentException("El nombre no debe tener más de 100 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(value, nombre.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
