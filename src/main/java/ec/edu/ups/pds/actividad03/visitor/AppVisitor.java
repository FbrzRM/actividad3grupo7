package ec.edu.ups.pds.actividad03.visitor;

import java.time.LocalDate;

/**
 * Programa de demostración del patrón Visitor:
 * inventario de activos de TI de la universidad.
 * Las fechas se calculan a partir de la fecha actual para que la demostración
 * produzca los mismos hallazgos en cualquier momento en que se ejecute.
 */
public class AppVisitor {

    public static void main(String[] args) {
        System.out.println("=== Patrón 02: Visitor - Inventario de activos de TI ===\n");
        LocalDate hoy = LocalDate.now();

        InventarioTI inventario = new InventarioTI();
        inventario.agregarActivo(new Computador("PC-001", "Computador laboratorio de redes", 1200,
                hoy.minusYears(1), "Intel Core i7", 16));
        inventario.agregarActivo(new Computador("PC-002", "Computador secretaría académica", 850,
                hoy.minusYears(6), "Intel Core i3", 4));
        inventario.agregarActivo(new Impresora("IMP-01", "Impresora multifunción biblioteca", 900,
                hoy.minusYears(2), 62_000, 12));
        inventario.agregarActivo(new Servidor("SRV-01", "Servidor del sistema académico", 15000,
                hoy.minusYears(3), 8, hoy.minusDays(12)));
        inventario.agregarActivo(new LicenciaSoftware("LIC-01", "Licencia software estadístico", 3600,
                hoy.minusMonths(34), hoy.plusMonths(2).minusDays(15), 50));
        inventario.agregarActivo(new LicenciaSoftware("LIC-02", "Licencia antivirus institucional", 1800,
                hoy.minusMonths(13), hoy.minusMonths(1), 300));

        // Operación 1: Finanzas
        System.out.println("1) Depreciación anual (Finanzas)");
        VisitanteDepreciacion depreciacion = new VisitanteDepreciacion();
        inventario.aplicar(depreciacion);
        System.out.printf("   Total de depreciación anual del inventario: $%,.2f%n%n", depreciacion.getTotalDepreciacion());

        // Operación 2: Soporte técnico
        System.out.println("2) Mantenimiento preventivo (Soporte técnico)");
        VisitanteMantenimiento mantenimiento = new VisitanteMantenimiento();
        inventario.aplicar(mantenimiento);
        mantenimiento.getTareas().forEach(t -> System.out.println("   - " + t));
        System.out.println();

        // Operación 3: Seguridad informática
        System.out.println("3) Auditoría de seguridad (Seguridad informática)");
        VisitanteAuditoriaSeguridad auditoria = new VisitanteAuditoriaSeguridad();
        inventario.aplicar(auditoria);
        auditoria.getHallazgos().forEach(h -> System.out.println("   - " + h));
    }
}
