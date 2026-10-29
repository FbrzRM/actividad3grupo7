package ec.edu.ups.pds.actividad03.chainofresponsibility;

/**
 * Participante GoF: ConcreteHandler.
 * Resuelve fallas de los sistemas institucionales.
 */
public class Especialista extends NivelSoporte {

    public Especialista() {
        super("Nivel 3 - Especialista");
    }

    @Override
    protected boolean puedeResolver(Incidente i) {
        return i.getTipo() == TipoIncidente.FALLA_SISTEMA;
    }

    @Override
    protected void resolver(Incidente i) {
        System.out.println("   " + nombre + " resuelve: Diagnostica y corrige la falla del sistema institucional.");
    }
}
