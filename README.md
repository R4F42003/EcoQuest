# EcoQuest

EcoQuest es un mini–proyecto que modela un sistema de gestión de misiones ecológicas (educativas, de limpieza y de plantación). Permite registrar voluntarios, asociar puntos ecológicos, asignar misiones y generar reportes, todo mediante interacción desde consola.

---

## Justificación del uso de colecciones

En este proyecto se emplean colecciones (`List`, `Set`, `Map`) porque permiten modelar relaciones dinámicas y manejar múltiples elementos de manera eficiente:

- **List**: se usa cuando importa el orden y puede haber elementos repetidos, como los puntos ecológicos asociados a una misión.  
- **Set**: garantiza que no existan duplicados, útil para las habilidades de un voluntario o las misiones asignadas/completadas.  
- **Map**: permite acceder rápidamente a los objetos por su identificador (ID), como en los servicios que gestionan misiones, voluntarios o puntos ecológicos.

Gracias a estas colecciones, el sistema es más flexible, escalable y refleja mejor la realidad (un voluntario con varias misiones, una misión con varios puntos, etc.).

---

## Principios SOLID aplicados

- **S (Single Responsibility Principle)**: cada clase tiene una única responsabilidad.  
  Ejemplo: `MisionServiceImpl` gestiona únicamente misiones, `VoluntarioServiceImpl` gestiona voluntarios y los *controllers* manejan la interacción con el usuario en consola (por ejemplo, `AgregarVoluntarioController` solo registra voluntarios).  

- **O (Open/Closed Principle)**: las clases de misión son extensibles mediante herencia (`MisionEducacion`, `MisionLimpieza`, `MisionPlantacion`) sin modificar la clase base `Mision`. Asimismo, es posible agregar nuevos *controllers* para nuevos casos de uso sin cambiar los existentes.  

- **L (Liskov Substitution Principle)**: las subclases de `Mision` pueden reemplazar a la clase padre en cualquier contexto, ya que todas implementan el método `complemento()`. En el caso de los *controllers*, cualquiera que implemente la misma lógica de interacción puede ser sustituido en el `MenuPrincipalController`.  

- **I (Interface Segregation Principle)**: se definen interfaces específicas (`MisionServices`, `VoluntarioService`, `PuntoEcologicoService`) para no forzar a implementar métodos innecesarios. Cada controller consume solo los servicios que necesita, evitando dependencias innecesarias.  

- **D (Dependency Inversion Principle)**: el código depende de interfaces y no de implementaciones concretas. Los *controllers* trabajan con `MisionServices`, `VoluntarioService` o `PuntoEcologicoService` sin conocer las clases concretas, lo que facilita intercambiar implementaciones sin modificar la lógica de interacción en consola.  

De esta forma, los *controllers* cumplen un rol fundamental en el proyecto: actúan como la **capa de interacción con el usuario** desde consola, orquestando la entrada de datos mediante `Scanner`, mostrando opciones y delegando la lógica en los servicios. Gracias a esta separación, el sistema es modular, fácil de mantener y preparado para escalar a otras formas de interacción (como una API REST o una interfaz gráfica) sin alterar la lógica de negocio.

---

## Diagrama de clases

```mermaid
classDiagram
    %% ===== JERARQUÍA DE MISIONES =====
    class Mision {
      <<abstract>>
      - String id
      - String descripcion
      - Estado estado
      - List~String~ puntosEcos     %% IDs de PuntoEco
      - LocalDate fecha
      - Dificultad nivelDificultad
      - TipoMision tipoMision

      + String complemento()         %% abstract
    }

    class MisionEducacion {
      - LugarMisionEducativa lugarMisionEducativa
      + String complemento()         %% override
    }

    class MisionLimpieza {
      - TipoLimpieza tipoLimpieza
      - double cantExtBasuraRecogida
      - double cantBasuraRecogida
      + String complemento()         %% override
    }

    class MisionPlantacion {
      - ZonaPlantacion zonaPlantacion
      - int extCantPlantada
      - int cantidadPlantada
      + String complemento()         %% override
    }

    Mision <|-- MisionEducacion
    Mision <|-- MisionLimpieza
    Mision <|-- MisionPlantacion

    %% ===== PUNTO ECO Y UBICACIÓN =====
    class PuntoEco {
      - String id
      - String nombre
      - Ecosistema tipoEcosistema
      - Ubicacion ubicacion
    }

    class Ubicacion {
      - double latitud
      - double longitud
    }

    PuntoEco o-- Ubicacion : contiene
    Mision "0..*" ..> PuntoEco : usa por ID (puntosEcos)

    %% ===== VOLUNTARIO =====
    class Voluntario {
      - String id
      - String nombre
      - Set~String~ habilidades
      - Set~String~ misionesAsignadas     %% IDs de Mision
      - Set~String~ misionesCompletadas   %% IDs de Mision
    }

    Voluntario "0..*" ..> Mision : asignadas/completadas (IDs)
