package ec.edu.ups.pds.actividad03.chainofresponsibility;

/**
 * Participante GoF: ConcreteHandler.
 * Resuelve problemas básicos, como restablecer una contraseña.
 */
public class Chatbot extends NivelSoporte {

    public Chatbot() {
        super("Nivel 1 - Chatbot");
    }

    @Override
    protected boolean puedeResolver(Incidente i) {
        return i.getTipo() == TipoIncidente.CONTRASENA;
    }

    @Override
    protected void resolver(Incidente i) {
        System.out.println("   " + nombre + " resuelve: Envía al usuario el enlace de autoservicio para restablecer su contraseña.");
    }
}
