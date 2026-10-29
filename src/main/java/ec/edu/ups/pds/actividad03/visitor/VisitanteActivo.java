package ec.edu.ups.pds.actividad03.visitor;

/**
 * Participante GoF: Visitor.
 * Declara una operación de visita por cada tipo de activo (ConcreteElement).
 * Cada método recibe el activo concreto, lo que permite acceder a sus datos específicos.
 */
public interface VisitanteActivo {

    void visitarComputador(Computador c);

    void visitarImpresora(Impresora i);

    void visitarServidor(Servidor s);

    void visitarLicencia(LicenciaSoftware l);
}
