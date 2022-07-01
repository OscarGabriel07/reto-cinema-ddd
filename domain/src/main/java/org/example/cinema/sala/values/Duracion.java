package org.example.cinema.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Integer> {

    private final Integer value;

    public Duracion(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value < 30){
            throw new IllegalArgumentException("Debe durar más de 30 minutos");
        }
    }

    public Duracion actualizarDuracion(Integer duracionActualizar){
        return new Duracion(duracionActualizar);
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duracion duracion = (Duracion) o;
        return Objects.equals(value, duracion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
