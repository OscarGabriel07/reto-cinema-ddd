package org.example.cinema.sucursal.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.cinema.factura.values.Nombre;

import java.util.Objects;

public class NombreSucursal implements ValueObject<String>{

    private final String value;

    public NombreSucursal(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre de la sucursal no debe estar vacío");
        }
        if(this.value.length() <= 3){
            throw new IllegalArgumentException("El nombre de la sucursal debe tener más de 3 caracteres");
        }
    }

    public NombreSucursal cambiarNombreSucursal(String nombreSucursalModificar){
        return new NombreSucursal(nombreSucursalModificar);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreSucursal that = (NombreSucursal) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
