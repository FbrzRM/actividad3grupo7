package ec.edu.ups.pds.actividad03.chainofresponsibility;

/**
 * Participante GoF: ConcreteHandler.
 * Resuelve problemas de configuración de equipos, correo o red.
 */
public class TecnicoSoporte extends NivelSoporte {

    public TecnicoSoporte() {
        super("Nivel 2 - Técnico de soporte");
    }

    @Override
    protected boolean puedeResolver(Incidente i) {
        return i.getTipo() == TipoIncidente.CONFIGURACION;
    }

    @Override
    protected void resolver(Incidente i) {
        System.out.println("   " + nombre + " resuelve: Configura el equipo, el correo o la red del usuario.");
    }
}
