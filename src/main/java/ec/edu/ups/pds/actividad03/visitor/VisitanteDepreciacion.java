package ec.edu.ups.pds.actividad03.visitor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Participante GoF: ConcreteVisitor.
 * Operación del área de Finanzas: calcula la depreciación anual de cada activo
 * (método de línea recta) y acumula el total del inventario.
 * La vida útil de cada tipo de equipo corresponde a una política institucional de ejemplo.
 */
public class VisitanteDepreciacion implements VisitanteActivo {

    private static final int VIDA_UTIL_COMPUTADOR = 3;
    private static final int VIDA_UTIL_IMPRESORA = 4;
    private static final int VIDA_UTIL_SERVIDOR = 5;

    private double totalDepreciacion;

    @Override
    public void visitarComputador(Computador c) {
        registrar(c, c.getCostoAdquisicion() / VIDA_UTIL_COMPUTADOR, VIDA_UTIL_COMPUTADOR + " años de vida útil");
    }

    @Override
    public void visitarImpresora(Impresora i) {
        registrar(i, i.getCostoAdquisicion() / VIDA_UTIL_IMPRESORA, VIDA_UTIL_IMPRESORA + " años de vida útil");
    }

    @Override
    public void visitarServidor(Servidor s) {
        registrar(s, s.getCostoAdquisicion() / VIDA_UTIL_SERVIDOR, VIDA_UTIL_SERVIDOR + " años de vida útil");
    }

    /** Una licencia no se deprecia como un equipo: se amortiza según su vigencia. */
    @Override
    public void visitarLicencia(LicenciaSoftware l) {
        LocalDate inicio = l.getFechaAdquisicion();
        long meses = Math.max(1, ChronoUnit.MONTHS.between(inicio, l.getFechaVencimiento()));
        double anual = l.getCostoAdquisicion() / meses * 12;
        registrar(l, Math.min(anual, l.getCostoAdquisicion()), "amortización en " + meses + " meses de vigencia");
    }

    private void registrar(ActivoTI a, double valor, String criterio) {
        totalDepreciacion += valor;
        System.out.printf("   %-8s %-34s $%,10.2f  (%s)%n", a.getCodigo(), a.getDescripcion(), valor, criterio);
    }

    public double getTotalDepreciacion() {
        return totalDepreciacion;
    }
}
