package ec.edu.ups.pds.actividad03.visitor;

import java.time.LocalDate;

/**
 * Participante GoF: ConcreteElement.
 * Impresora institucional.
 */
public class Impresora extends ActivoTI {

    private int paginasImpresas;
    private int nivelToner;

    public Impresora(String codigo, String descripcion, double costoAdquisicion, LocalDate fechaAdquisicion,
            int paginasImpresas, int nivelToner) {
        super(codigo, descripcion, costoAdquisicion, fechaAdquisicion);
        this.paginasImpresas = paginasImpresas;
        this.nivelToner = nivelToner;
    }

    /** Doble despacho: el activo invoca el método del visitante que le corresponde y se pasa a sí mismo. */
    @Override
    public void aceptar(VisitanteActivo v) {
        v.visitarImpresora(this);
    }

    public int getPaginasImpresas() {
        return paginasImpresas;
    }

    public int getNivelToner() {
        return nivelToner;
    }
}
