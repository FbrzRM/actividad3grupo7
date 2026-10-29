package ec.edu.ups.pds.actividad03.chainofresponsibility;

/**
 * Tipos de incidente que puede recibir la mesa de ayuda.
 * Cada nivel de soporte usa este valor para decidir si puede atender el incidente.
 */
public enum TipoIncidente {
    CONTRASENA,
    CONFIGURACION,
    FALLA_SISTEMA,
    ERROR_FABRICANTE
}
