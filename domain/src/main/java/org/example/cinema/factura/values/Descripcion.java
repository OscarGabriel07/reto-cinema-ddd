package org.example.cinema.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {

    private final String value;

    public Descripcion(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La descripción no debe estar vacía");
        }
        if(this.value.length() <= 4){
            throw new IllegalArgumentException("La descripción debe tener más de 4 caracteres");
        }
    }

    public Descripcion actualizarDescripcion(String descripcionActualizar){
        return new Descripcion(descripcionActualizar);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
