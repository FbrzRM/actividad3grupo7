package ec.edu.ups.pds.actividad03.chainofresponsibility;

/**
 * Participante GoF: Request.
 * Representa la solicitud que recorre la cadena de niveles de soporte.
 */
public class Incidente {

    private final int id;
    private final String descripcion;
    private final TipoIncidente tipo;
    private boolean resuelto;
    private String resueltoPor;

    public Incidente(int id, String descripcion, TipoIncidente tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.resuelto = false;
        this.resueltoPor = null;
    }

    public TipoIncidente getTipo() {
        return tipo;
    }

    /** Registra qué nivel de soporte resolvió el incidente. */
    public void marcarResuelto(String nivel) {
        this.resuelto = true;
        this.resueltoPor = nivel;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    public String getResueltoPor() {
        return resueltoPor;
    }

    @Override
    public String toString() {
        return "Incidente #" + id + " [" + tipo + "] " + descripcion;
    }
}
