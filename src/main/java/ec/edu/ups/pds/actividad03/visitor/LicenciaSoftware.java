package ec.edu.ups.pds.actividad03.visitor;

import java.time.LocalDate;

/**
 * Participante GoF: ConcreteElement.
 * Licencia de software con fecha de vencimiento.
 */
public class LicenciaSoftware extends ActivoTI {

    private LocalDate fechaVencimiento;
    private int numeroUsuarios;

    public LicenciaSoftware(String codigo, String descripcion, double costoAdquisicion, LocalDate fechaAdquisicion,
            LocalDate fechaVencimiento, int numeroUsuarios) {
        super(codigo, descripcion, costoAdquisicion, fechaAdquisicion);
        this.fechaVencimiento = fechaVencimiento;
        this.numeroUsuarios = numeroUsuarios;
    }

    /** Doble despacho: el activo invoca el método del visitante que le corresponde y se pasa a sí mismo. */
    @Override
    public void aceptar(VisitanteActivo v) {
        v.visitarLicencia(this);
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getNumeroUsuarios() {
        return numeroUsuarios;
    }
}
