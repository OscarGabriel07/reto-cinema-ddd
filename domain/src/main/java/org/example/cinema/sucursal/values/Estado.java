package org.example.cinema.sucursal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado implements ValueObject<Boolean> {

    private final Boolean value;

    public Estado(Boolean value){
        this.value = Objects.requireNonNull(value);
        if(this.value != true && this.value != false){
            throw new IllegalArgumentException("Debe ingresar true para verdadero y false para falso");
        }
    }

    public Estado cambiarEstado(Boolean estadoCambiar){
        return new Estado(estadoCambiar);
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(value, estado.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
