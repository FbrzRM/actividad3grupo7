package ec.edu.ups.pds.actividad03.chainofresponsibility;

/**
 * Participante GoF: Client.
 * Construye la cadena de niveles de soporte y envía cada incidente al primer eslabón,
 * sin conocer qué nivel lo resolverá.
 */
public class GestorIncidentes {

    private NivelSoporte primerNivel;

    /** Cadena: Chatbot -> TecnicoSoporte -> Especialista -> ProveedorExterno. */
    public void construirCadena() {
        primerNivel = new Chatbot();
        primerNivel.establecerSiguiente(new TecnicoSoporte())
                   .establecerSiguiente(new Especialista())
                   .establecerSiguiente(new ProveedorExterno());
    }

    public void registrarIncidente(Incidente i) {
        if (primerNivel == null) {
            construirCadena();
        }
        System.out.println(i);
        primerNivel.atender(i);
        System.out.println("   => Resuelto por: " + (i.isResuelto() ? i.getResueltoPor() : "nadie") + "\n");
    }
}
