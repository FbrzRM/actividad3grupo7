package ec.edu.ups.pds.actividad03.chainofresponsibility;

/**
 * Programa de demostración del patrón Chain of Responsibility:
 * mesa de ayuda de TI por niveles de soporte.
 */
public class AppChainOfResponsibility {

    public static void main(String[] args) {
        System.out.println("=== Patrón 01: Chain of Responsibility - Mesa de ayuda ===\n");

        GestorIncidentes gestor = new GestorIncidentes();
        gestor.construirCadena();

        gestor.registrarIncidente(new Incidente(1, "Olvidé la contraseña del aula virtual", TipoIncidente.CONTRASENA));
        gestor.registrarIncidente(new Incidente(2, "No puedo configurar el correo institucional en el celular", TipoIncidente.CONFIGURACION));
        gestor.registrarIncidente(new Incidente(3, "El sistema académico no registra las calificaciones", TipoIncidente.FALLA_SISTEMA));
        gestor.registrarIncidente(new Incidente(4, "Error interno en el software de laboratorio", TipoIncidente.ERROR_FABRICANTE));
    }
}
