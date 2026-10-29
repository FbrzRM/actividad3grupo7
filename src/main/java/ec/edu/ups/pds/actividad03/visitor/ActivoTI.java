package ec.edu.ups.pds.actividad03.visitor;

import java.time.LocalDate;

/**
 * Participante GoF: Element.
 * Define los datos comunes de un activo de TI y declara aceptar(),
 * mediante el cual el activo recibe a un visitante.
 */
public abstract class ActivoTI {

    protected String codigo;
    protected String descripcion;
    protected double costoAdquisicion;
    protected LocalDate fechaAdquisicion;

    protected ActivoTI(String codigo, String descripcion, double costoAdquisicion, LocalDate fechaAdquisicion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costoAdquisicion = costoAdquisicion;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    /** Punto de entrada del doble despacho. */
    public abstract void aceptar(VisitanteActivo v);

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCostoAdquisicion() {
        return costoAdquisicion;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }
}
