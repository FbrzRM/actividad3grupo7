# PDS – Actividad 03: Patrones de comportamiento (Grupo 07)

**Integrantes:** Aristega Salinas David Oswaldo · Ramos Mesias Mauro Fabrizio

Implementación en Java de los dos patrones de comportamiento del informe `PDS_Actividad_03_Grupo07`.
Las clases, atributos y métodos corresponden a los diagramas de clases UML de la carpeta `docs/uml`.

| Patrón | Escenario | Paquete |
|---|---|---|
| Chain of Responsibility | Mesa de ayuda de TI por niveles de soporte | `ec.edu.ups.pds.actividad03.chainofresponsibility` |
| Visitor | Inventario de activos de TI de la universidad | `ec.edu.ups.pds.actividad03.visitor` |

## Patrón 01: Chain of Responsibility

| Participante GoF | Clase |
|---|---|
| Handler | `NivelSoporte` (clase abstracta) |
| ConcreteHandler | `Chatbot`, `TecnicoSoporte`, `Especialista`, `ProveedorExterno` |
| Client | `GestorIncidentes` |
| Request | `Incidente` (con el enum `TipoIncidente`) |

Cadena: `Chatbot → TecnicoSoporte → Especialista → ProveedorExterno`.
`NivelSoporte.atender()` resuelve el incidente si `puedeResolver()` lo permite; si no, lo escala al siguiente nivel.
`ProveedorExterno` es el último eslabón y atiende cualquier incidente, por lo que ninguno queda sin atención.

## Patrón 02: Visitor

| Participante GoF | Clase |
|---|---|
| Visitor | `VisitanteActivo` (interfaz) |
| ConcreteVisitor | `VisitanteDepreciacion`, `VisitanteMantenimiento`, `VisitanteAuditoriaSeguridad` |
| Element | `ActivoTI` (clase abstracta) |
| ConcreteElement | `Computador`, `Impresora`, `Servidor`, `LicenciaSoftware` |
| ObjectStructure | `InventarioTI` |

Doble despacho: `InventarioTI.aplicar(v)` llama a `activo.aceptar(v)`, y cada activo responde con el método
que le corresponde, por ejemplo `v.visitarServidor(this)`. Para agregar una nueva operación
(por ejemplo, el consumo energético) basta con crear una nueva clase que implemente `VisitanteActivo`.

## Ejecución

Requisito: JDK 17 o superior.

**Con Maven**

```bash
mvn compile
java -cp target/classes ec.edu.ups.pds.actividad03.chainofresponsibility.AppChainOfResponsibility
java -cp target/classes ec.edu.ups.pds.actividad03.visitor.AppVisitor
```

**Solo con el JDK**

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out ec.edu.ups.pds.actividad03.chainofresponsibility.AppChainOfResponsibility
java -cp out ec.edu.ups.pds.actividad03.visitor.AppVisitor
```

En Windows, si la consola muestra mal las tildes, ejecute antes `chcp 65001`.
También puede abrir el proyecto en IntelliJ IDEA, NetBeans o VS Code y ejecutar directamente las clases `AppChainOfResponsibility` y `AppVisitor`.

## Estructura

```
src/main/java/ec/edu/ups/pds/actividad03/
├── chainofresponsibility/   Patrón 01
└── visitor/                 Patrón 02
docs/uml/                    Diagramas UML (.drawio y .png)
```

> Por convención, los diagramas UML omiten constructores y métodos de acceso (getters).
