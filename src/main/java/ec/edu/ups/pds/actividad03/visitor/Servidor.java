package ec.edu.ups.pds.actividad03.visitor;

import java.time.LocalDate;

/**
 * Participante GoF: ConcreteElement.
 * Servidor que aloja los sistemas institucionales.
 */
public class Servidor extends ActivoTI {

    private int capacidadDiscoTB;
    private LocalDate ultimoRespaldo;

    public Servidor(String codigo, String descripcion, double costoAdquisicion, LocalDate fechaAdquisicion,
            int capacidadDiscoTB, LocalDate ultimoRespaldo) {
        super(codigo, descripcion, costoAdquisicion, fechaAdquisicion);
        this.capacidadDiscoTB = capacidadDiscoTB;
        this.ultimoRespaldo = ultimoRespaldo;
    }

    /** Doble despacho: el activo invoca el método del visitante que le corresponde y se pasa a sí mismo. */
    @Override
    public void aceptar(VisitanteActivo v) {
        v.visitarServidor(this);
    }

    public int getCapacidadDiscoTB() {
        return capacidadDiscoTB;
    }

    public LocalDate getUltimoRespaldo() {
        return ultimoRespaldo;
    }
}
