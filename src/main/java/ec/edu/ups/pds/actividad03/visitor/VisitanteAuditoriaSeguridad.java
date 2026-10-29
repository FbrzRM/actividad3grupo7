package ec.edu.ups.pds.actividad03.visitor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Participante GoF: ConcreteVisitor.
 * Operación del área de Seguridad informática: registra los hallazgos de seguridad
 * detectados en cada tipo de activo.
 */
public class VisitanteAuditoriaSeguridad implements VisitanteActivo {

    private final List<String> hallazgos = new ArrayList<>();

    @Override
    public void visitarComputador(Computador c) {
        long anios = ChronoUnit.YEARS.between(c.getFechaAdquisicion(), LocalDate.now());
        if (anios >= 5) {
            hallazgos.add(c.getCodigo() + ": equipo con " + anios + " años, posible falta de actualizaciones de seguridad");
        }
    }

    @Override
    public void visitarImpresora(Impresora i) {
        hallazgos.add(i.getCodigo() + ": verificar que la administración web no use credenciales por defecto");
    }

    @Override
    public void visitarServidor(Servidor s) {
        long dias = ChronoUnit.DAYS.between(s.getUltimoRespaldo(), LocalDate.now());
        if (dias > 7) {
            hallazgos.add(s.getCodigo() + ": CRÍTICO - respaldo desactualizado, riesgo de pérdida de información");
        }
    }

    @Override
    public void visitarLicencia(LicenciaSoftware l) {
        if (l.getFechaVencimiento().isBefore(LocalDate.now())) {
            hallazgos.add(l.getCodigo() + ": licencia vencida, el software no recibe parches de seguridad");
        }
    }

    public List<String> getHallazgos() {
        return hallazgos;
    }
}
