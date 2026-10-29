package ec.edu.ups.pds.actividad03.chainofresponsibility;

/**
 * Participante GoF: ConcreteHandler.
 * Último eslabón: atiende cualquier incidente que no pudo resolverse internamente,
 * por lo que ningún incidente queda sin atención.
 */
public class ProveedorExterno extends NivelSoporte {

    public ProveedorExterno() {
        super("Proveedor externo");
    }

    @Override
    protected boolean puedeResolver(Incidente i) {
        return true;
    }

    @Override
    protected void resolver(Incidente i) {
        System.out.println("   " + nombre + " resuelve: Abre un caso con el fabricante y da seguimiento hasta su solución.");
    }
}
