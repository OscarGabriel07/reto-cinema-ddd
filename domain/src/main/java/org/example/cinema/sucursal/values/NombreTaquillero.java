package org.example.cinema.sucursal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreTaquillero implements ValueObject<String> {

    private final String value;

    public NombreTaquillero(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre del taquillero no debe estar vacío");
        }
        if(this.value.length() <= 3){
            throw new IllegalArgumentException("El nombre del taquillero debe tener más de 3 caracteres");
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
        NombreTaquillero that = (NombreTaquillero) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
