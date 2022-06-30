package org.example.cinema.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TiempoTranscurrido implements ValueObject<Integer> {

    private final Integer value;

    public TiempoTranscurrido(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("El tiempo transcurrido de la película no puede ser negativo");
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
        TiempoTranscurrido that = (TiempoTranscurrido) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
