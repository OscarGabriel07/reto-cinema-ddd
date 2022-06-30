package org.example.cinema.sucursal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeFila implements ValueObject<String> {

    private final String value;

    public TipoDeFila(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El tipo de fila no debe estar vacío");
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
        TipoDeFila that = (TipoDeFila) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
