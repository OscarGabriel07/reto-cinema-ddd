package org.example.cinema.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FechaImpresion implements ValueObject<String> {
    private final LocalDate fecha;
    private final String formato;

    public FechaImpresion(int dia, int mes, int anio){
        this.fecha = LocalDate.of(dia, mes, anio);
        if(this.fecha.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La fecha no puede ser posterior a la fecha actual");
        }
        formato = generarFormato();
    }

    private String generarFormato(){
        return fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String value() {
        return formato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaImpresion that = (FechaImpresion) o;
        return Objects.equals(formato, that.formato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formato);
    }
}
