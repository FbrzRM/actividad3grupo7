package ec.edu.ups.pds.actividad03.chainofresponsibility;

/**
 * Participante GoF: Handler.
 * Define la interfaz común para atender incidentes y mantiene la referencia
 * al siguiente nivel de la cadena (asociación "siguiente 0..1" del diagrama UML).
 */
public abstract class NivelSoporte {

    protected NivelSoporte siguiente;
    protected String nombre;

    protected NivelSoporte(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Enlaza el siguiente nivel de la cadena.
     * Devuelve el nivel recibido para poder encadenar las llamadas:
     * chatbot.establecerSiguiente(tecnico).establecerSiguiente(especialista)...
     */
    public NivelSoporte establecerSiguiente(NivelSoporte s) {
        this.siguiente = s;
        return s;
    }

    /**
     * Lógica de la cadena (ver la nota del diagrama UML):
     * si este nivel puede resolver el incidente, lo resuelve;
     * si no, lo escala al siguiente nivel; si no existe un siguiente, el incidente queda sin atender.
     */
    public void atender(Incidente i) {
        if (puedeResolver(i)) {
            resolver(i);
            i.marcarResuelto(nombre);
        } else if (siguiente != null) {
            System.out.println("   " + nombre + " no puede resolverlo -> escala al siguiente nivel");
            siguiente.atender(i);
        } else {
            System.out.println("   " + nombre + " no puede resolverlo y no hay más niveles: incidente sin atender");
        }
    }

    /** Regla propia de cada nivel para decidir si el incidente le corresponde. */
    protected abstract boolean puedeResolver(Incidente i);

    /** Forma en que cada nivel atiende el incidente. */
    protected abstract void resolver(Incidente i);
}
