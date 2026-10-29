package ec.edu.ups.pds.actividad03.visitor;

import java.time.LocalDate;

/**
 * Participante GoF: ConcreteElement.
 * Computador de escritorio o portátil de la universidad.
 */
public class Computador extends ActivoTI {

    private String procesador;
    private int memoriaRAM;

    public Computador(String codigo, String descripcion, double costoAdquisicion, LocalDate fechaAdquisicion,
            String procesador, int memoriaRAM) {
        super(codigo, descripcion, costoAdquisicion, fechaAdquisicion);
        this.procesador = procesador;
        this.memoriaRAM = memoriaRAM;
    }

    /** Doble despacho: el activo invoca el método del visitante que le corresponde y se pasa a sí mismo. */
    @Override
    public void aceptar(VisitanteActivo v) {
        v.visitarComputador(this);
    }

    public String getProcesador() {
        return procesador;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }
}
