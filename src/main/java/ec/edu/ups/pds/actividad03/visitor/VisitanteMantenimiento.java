package ec.edu.ups.pds.actividad03.visitor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Participante GoF: ConcreteVisitor.
 * Operación del área de Soporte técnico: genera las tareas de mantenimiento preventivo
 * según los datos propios de cada tipo de activo.
 */
public class VisitanteMantenimiento implements VisitanteActivo {

    private final List<String> tareas = new ArrayList<>();

    @Override
    public void visitarComputador(Computador c) {
        tareas.add(c.getCodigo() + ": limpieza física y actualización del sistema operativo");
        if (c.getMemoriaRAM() < 8) {
            tareas.add(c.getCodigo() + ": evaluar ampliación de memoria RAM (" + c.getMemoriaRAM() + " GB)");
        }
    }

    @Override
    public void visitarImpresora(Impresora i) {
        if (i.getNivelToner() < 20) {
            tareas.add(i.getCodigo() + ": reemplazar tóner (nivel " + i.getNivelToner() + " %)");
        }
        if (i.getPaginasImpresas() > 50_000) {
            tareas.add(i.getCodigo() + ": revisar rodillos y fusor (" + i.getPaginasImpresas() + " páginas impresas)");
        }
    }

    @Override
    public void visitarServidor(Servidor s) {
        tareas.add(s.getCodigo() + ": verificar el estado de los discos (" + s.getCapacidadDiscoTB() + " TB)");
        long dias = ChronoUnit.DAYS.between(s.getUltimoRespaldo(), LocalDate.now());
        if (dias > 7) {
            tareas.add(s.getCodigo() + ": ejecutar respaldo pendiente (último hace " + dias + " días)");
        }
    }

    @Override
    public void visitarLicencia(LicenciaSoftware l) {
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), l.getFechaVencimiento());
        if (dias >= 0 && dias <= 60) {
            tareas.add(l.getCodigo() + ": gestionar la renovación (vence en " + dias + " días)");
        }
    }

    public List<String> getTareas() {
        return tareas;
    }
}
