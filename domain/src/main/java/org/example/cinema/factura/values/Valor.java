package org.example.cinema.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valor implements ValueObject<Integer> {

    private final Integer value;

    public Valor(Integer value){
        this.value = value;
        if(this.value < 0){
            throw new IllegalArgumentException("El valor no debe ser negativo");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valor valor = (Valor) o;
        return Objects.equals(value, valor.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
