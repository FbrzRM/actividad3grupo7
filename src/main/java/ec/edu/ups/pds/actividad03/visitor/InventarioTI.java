package ec.edu.ups.pds.actividad03.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Participante GoF: ObjectStructure.
 * Almacena la colección de activos y permite aplicar un visitante a todos ellos.
 */
public class InventarioTI {

    private final List<ActivoTI> activos = new ArrayList<>();

    public void agregarActivo(ActivoTI a) {
        activos.add(a);
    }

    /** Recorre el inventario y entrega el visitante a cada activo. */
    public void aplicar(VisitanteActivo v) {
        for (ActivoTI a : activos) {
            a.aceptar(v);
        }
    }
}
