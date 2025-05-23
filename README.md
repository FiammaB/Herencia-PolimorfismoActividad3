# Ejercicios de Java Orientados a Objetos

Este repositorio contiene dos ejercicios de programación en Java diseñados para ilustrar y practicar los fundamentos de la **Programación Orientada a Objetos (POO)**. Nos enfocamos en conceptos clave como la **herencia**, el **polimorfismo** y el **downcasting**.

---

## 1. Concesionaria de Vehículos

Este ejercicio simula el funcionamiento de una concesionaria de vehículos. El objetivo principal es demostrar cómo se pueden modelar objetos del mundo real utilizando los principios de la POO.

### Conceptos de POO Aplicados

* **Clases y Objetos:** Representamos entidades como `Vehiculo`, `Auto`, `Moto` y `Concesionaria` como clases. Cada instancia de estas clases es un objeto.
* **Encapsulación:** Las propiedades internas de las clases (ej., `marca`, `modelo`, `patente`) son privadas, lo que significa que el acceso y la modificación de estos datos se realizan de manera controlada a través de métodos públicos (getters y setters). Esto asegura la integridad de los objetos.
* **Herencia:**
    * La clase `Vehiculo` es una **clase abstracta**. Esto significa que no se pueden crear objetos `Vehiculo` directamente, pero define un contrato común para todos los vehículos. Contiene atributos y métodos generales (como `acelerar()`, `frenar()`, `encender()`) que son universales para cualquier tipo de vehículo.
    * Las clases `Auto` y `Moto` **heredan** de `Vehiculo`. Esto establece una relación "es un": un `Auto` "es un" `Vehiculo` y una `Moto` también "es un" `Vehiculo`. Al heredar, `Auto` y `Moto` adquieren automáticamente las propiedades y comportamientos definidos en `Vehiculo`. Además, pueden añadir sus propias características específicas (ej., `tieneAire` en `Auto`, `anchoDeManubrio` en `Moto`) y comportamientos únicos (ej., `prenderAire()` en `Auto`, `hacerWheelie()` en `Moto`). Esto promueve la **reutilización de código** y establece una jerarquía lógica clara.
* **Polimorfismo:**
    * La clase `Concesionaria` utiliza un `ArrayList` de tipo `Vehiculo` (`ArrayList<Vehiculo>`). Esto es un ejemplo fundamental de polimorfismo: podemos almacenar objetos de tipo `Auto`, `Moto` o cualquier otra subclase de `Vehiculo` en esta única lista.
    * Cuando llamamos al método `agregarVehiculo(Vehiculo v)`, podemos pasar una instancia de `Auto` o de `Moto`. El sistema de tipos de Java permite que una referencia de tipo `Vehiculo` apunte a objetos de sus subclases. Esta capacidad de un objeto de tomar muchas formas (polimorfismo significa "muchas formas") es crucial para diseñar sistemas flexibles y extensibles. Por ejemplo, si en el futuro añadimos una clase `Camion` que también herede de `Vehiculo`, la `Concesionaria` podrá agregar camiones sin necesidad de modificar su código existente.
* **Downcasting (Casting Descendente):**
    * Aunque no se implementa explícitamente en el código proporcionado, el **downcasting** sería necesario si quisiéramos acceder a un método o atributo específico de una subclase desde una referencia de su superclase.
    * Por ejemplo, si recuperamos un `Vehiculo` de la `ArrayList` de la `Concesionaria`, este será de tipo `Vehiculo`. Para llamar a `prenderAire()` (que es exclusivo de `Auto`) o `hacerWheelie()` (exclusivo de `Moto`), primero debemos verificar si el objeto es realmente de ese tipo específico y luego realizar un downcasting.
    * **Ejemplo conceptual de downcasting:**
        ```java
        // Suponiendo que 'vehiculos' es el ArrayList<Vehiculo> de la Concesionaria
        for (Vehiculo v : concesionaria.getVehiculos()) { // Iteramos la lista usando la referencia Vehiculo
            if (v instanceof Auto) { // Verificamos si el objeto es realmente un Auto
                Auto auto = (Auto) v; // Realizamos el downcasting (lo tratamos como Auto)
                auto.prenderAire();    // Ahora podemos llamar al método específico de Auto
            } else if (v instanceof Moto) { // Verificamos si es una Moto
                Moto moto = (Moto) v;   // Realizamos el downcasting (lo tratamos como Moto)
                moto.hacerWheelie();    // Ahora podemos llamar al método específico de Moto
            }
            v.acelerar(); // Este método es polimórfico, se llama directamente sobre la referencia Vehiculo
        }
        ```
    * Es crucial usar el operador `instanceof` antes de realizar un downcasting para evitar una `ClassCastException` si el objeto no es del tipo esperado en tiempo de ejecución. El downcasting debe usarse con precaución, ya que un buen diseño polimórfico a menudo puede reducir su necesidad.

### Estructura del Código

```java
// Clase abstracta base
public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String patente;
    // Constructor y métodos comunes (acelerar, frenar, encender, etc.)
}

// Subclase de Vehiculo
public class Auto extends Vehiculo {
    private boolean tieneAire;
    // Constructor y método específico (prenderAire)
}

// Subclase de Vehiculo
public class Moto extends Vehiculo {
    private int anchoDeManubrio;
    // Constructor y método específico (hacerWheelie)
}

// Clase que utiliza el polimorfismo
public class Concesionaria {
    private ArrayList<Vehiculo> vehiculos; // Puede contener Autos, Motos, etc.
    public void agregarVehiculo(Vehiculo v) { /* ... */ } // Acepta cualquier Vehiculo
}

public class Principal {
    public static void main(String[] args) {
        // Lógica de ejemplo para crear y agregar vehículos
    }
}
### Cómo Ejecutar

1.  Asegúrate de que todos los archivos `.java` (`Auto.java`, `Concesionaria.java`, `Moto.java`, `Principal.java`, `Vehiculo.java`) estén en el mismo directorio.
2.  Compila las clases desde tu terminal. Abre la terminal o línea de comandos en el directorio donde guardaste los archivos y ejecuta:
    ```bash
    javac *.java
    ```
3.  Ejecuta la clase principal:
    ```bash
    java Principal
    ```

---

## 2. Baraja de Cartas Inglesa

Este ejercicio se enfoca en la creación de una baraja de cartas inglesa, aplicando la herencia para estructurar los diferentes tipos de cartas y el polimorfismo para manejarlas de forma unificada.

### Conceptos de POO Aplicados

* **Clases y Objetos:** Modelamos `Carta`, `CartaNumeral`, `CartaFigura`, `CartaJoker`, `Palo`, `Color` y la `BarajaInglesa` como clases o enumeraciones.
* **Encapsulación:** Las propiedades internas de cada carta (ej., `tapada`, `numero`, `letra`) se mantienen privadas y se gestionan a través del comportamiento de la carta.
* **Herencia:**
    * La clase `Carta` es la **clase base abstracta** de la que derivan todos los tipos de cartas. Define características y comportamientos comunes (como si la carta está `tapada` y el método `mostrar()`).
    * `CartaConPalo` es una **clase abstracta intermedia** que hereda de `Carta`. Sirve para agrupar todas las cartas que tienen un `Palo` (como las cartas numéricas y de figura).
    * `CartaNumeral` y `CartaFigura` **heredan** de `CartaConPalo`. Esto les permite tener un `Palo` y añadir sus propias características específicas (un `numero` para `CartaNumeral` o una `letra` para `CartaFigura`).
    * `CartaJoker` **hereda directamente de `Carta`** ya que los Jokers no tienen un palo tradicional. Esta jerarquía demuestra cómo la herencia puede modelar relaciones complejas donde algunas subclases comparten una base común, pero otras tienen características muy distintas que justifican una rama de herencia diferente.
* **Polimorfismo:**
    * La clase `BarajaInglesa` utiliza un `ArrayList` de tipo `Carta` (`ArrayList<Carta>`). Este es un ejemplo clave de polimorfismo, ya que la lista puede contener cualquier tipo de objeto que sea una `Carta` o una de sus subclases (`CartaNumeral`, `CartaFigura`, `CartaJoker`).
    * Cuando se itera sobre la lista de `cartas` en `BarajaInglesa` para llamar al método `mostrar()`, cada objeto individual (`CartaNumeral`, `CartaFigura` o `CartaJoker`) ejecutará su propia implementación específica de `mostrar()`. Aunque la referencia es de tipo `Carta`, el comportamiento real se determina en tiempo de ejecución según el tipo de objeto concreto al que se esté haciendo referencia. Esto permite manejar todos los tipos de cartas de forma genérica sin necesidad de escribir código condicional para cada tipo.
* **Downcasting (Casting Descendente):**
    * Similar al ejercicio anterior, el **downcasting** sería necesario si, por ejemplo, quisiéramos acceder al `numero` específico de una `CartaNumeral` o a la `letra` de una `CartaFigura` cuando estamos iterando la lista como `ArrayList<Carta>`.
    * **Ejemplo conceptual de downcasting:**
        ```java
        // Suponiendo que 'cartas' es el ArrayList<Carta> de la BarajaInglesa
        for (Carta carta : baraja.getCartas()) {
            if (carta instanceof CartaNumeral) {
                CartaNumeral numeral = (CartaNumeral) carta;
                // Ahora podemos acceder a numeral.getNumero() (si existiera ese getter)
                System.out.println("Es una carta numeral: " + numeral);
            } else if (carta instanceof CartaFigura) {
                CartaFigura figura = (CartaFigura) carta;
                // Acceder a figura.getLetra() (si existiera ese getter)
                System.out.println("Es una carta de figura: " + figura);
            } else if (carta instanceof CartaJoker) {
                CartaJoker joker = (CartaJoker) carta;
                // Acceder a joker.isAColor() (si existiera ese getter)
                System.out.println("Es un Joker: " + joker);
            }
            carta.mostrar(); // Este método usa el polimorfismo sin necesidad de downcasting
        }
        ```
    * El downcasting nos permite "bajar" en la jerarquía de herencia y tratar un objeto como un tipo más específico, habilitando el acceso a sus métodos y propiedades únicas. Sin embargo, siempre debe ir precedido de una verificación con `instanceof` para garantizar la seguridad de tipo en tiempo de ejecución.

### Estructura del Código
¡Perfecto! Aquí tienes la parte final, desde "Cómo Ejecutar" en adelante, lista para agregar a tu README.md.

Markdown

### Cómo Ejecutar

1.  Asegúrate de que todos los archivos `.java` (`Auto.java`, `Concesionaria.java`, `Moto.java`, `Principal.java`, `Vehiculo.java`) estén en el mismo directorio.
2.  Compila las clases desde tu terminal. Abre la terminal o línea de comandos en el directorio donde guardaste los archivos y ejecuta:
    ```bash
    javac *.java
    ```
3.  Ejecuta la clase principal:
    ```bash
    java Principal
    ```

---

## 2. Baraja de Cartas Inglesa

Este ejercicio se enfoca en la creación de una baraja de cartas inglesa, aplicando la herencia para estructurar los diferentes tipos de cartas y el polimorfismo para manejarlas de forma unificada.

### Conceptos de POO Aplicados

* **Clases y Objetos:** Modelamos `Carta`, `CartaNumeral`, `CartaFigura`, `CartaJoker`, `Palo`, `Color` y la `BarajaInglesa` como clases o enumeraciones.
* **Encapsulación:** Las propiedades internas de cada carta (ej., `tapada`, `numero`, `letra`) se mantienen privadas y se gestionan a través del comportamiento de la carta.
* **Herencia:**
    * La clase `Carta` es la **clase base abstracta** de la que derivan todos los tipos de cartas. Define características y comportamientos comunes (como si la carta está `tapada` y el método `mostrar()`).
    * `CartaConPalo` es una **clase abstracta intermedia** que hereda de `Carta`. Sirve para agrupar todas las cartas que tienen un `Palo` (como las cartas numéricas y de figura).
    * `CartaNumeral` y `CartaFigura` **heredan** de `CartaConPalo`. Esto les permite tener un `Palo` y añadir sus propias características específicas (un `numero` para `CartaNumeral` o una `letra` para `CartaFigura`).
    * `CartaJoker` **hereda directamente de `Carta`** ya que los Jokers no tienen un palo tradicional. Esta jerarquía demuestra cómo la herencia puede modelar relaciones complejas donde algunas subclases comparten una base común, pero otras tienen características muy distintas que justifican una rama de herencia diferente.
* **Polimorfismo:**
    * La clase `BarajaInglesa` utiliza un `ArrayList` de tipo `Carta` (`ArrayList<Carta>`). Este es un ejemplo clave de polimorfismo, ya que la lista puede contener cualquier tipo de objeto que sea una `Carta` o una de sus subclases (`CartaNumeral`, `CartaFigura`, `CartaJoker`).
    * Cuando se itera sobre la lista de `cartas` en `BarajaInglesa` para llamar al método `mostrar()`, cada objeto individual (`CartaNumeral`, `CartaFigura` o `CartaJoker`) ejecutará su propia implementación específica de `mostrar()`. Aunque la referencia es de tipo `Carta`, el comportamiento real se determina en tiempo de ejecución según el tipo de objeto concreto al que se esté haciendo referencia. Esto permite manejar todos los tipos de cartas de forma genérica sin necesidad de escribir código condicional para cada tipo.
* **Downcasting (Casting Descendente):**
    * Similar al ejercicio anterior, el **downcasting** sería necesario si, por ejemplo, quisiéramos acceder al `numero` específico de una `CartaNumeral` o a la `letra` de una `CartaFigura` cuando estamos iterando la lista como `ArrayList<Carta>`.
    * **Ejemplo conceptual de downcasting:**
        ```java
        // Suponiendo que 'cartas' es el ArrayList<Carta> de la BarajaInglesa
        for (Carta carta : baraja.getCartas()) {
            if (carta instanceof CartaNumeral) {
                CartaNumeral numeral = (CartaNumeral) carta;
                // Ahora podemos acceder a numeral.getNumero() (si existiera ese getter)
                System.out.println("Es una carta numeral: " + numeral);
            } else if (carta instanceof CartaFigura) {
                CartaFigura figura = (CartaFigura) carta;
                // Acceder a figura.getLetra() (si existiera ese getter)
                System.out.println("Es una carta de figura: " + figura);
            } else if (carta instanceof CartaJoker) {
                CartaJoker joker = (CartaJoker) carta;
                // Acceder a joker.isAColor() (si existiera ese getter)
                System.out.println("Es un Joker: " + joker);
            }
            carta.mostrar(); // Este método usa el polimorfismo sin necesidad de downcasting
        }
        ```
    * El downcasting nos permite "bajar" en la jerarquía de herencia y tratar un objeto como un tipo más específico, habilitando el acceso a sus métodos y propiedades únicas. Sin embargo, siempre debe ir precedido de una verificación con `instanceof` para garantizar la seguridad de tipo en tiempo de ejecución.

### Estructura del Código

baraja/
├── BarajaInglesa.java
├── Color.java (Enum para los colores de los palos)
├── Palo.java (Enum para los palos, asociado a Color)
├── Principal.java
└── cartas/
├── Carta.java (Clase abstracta base)
├── CartaConPalo.java (Clase abstracta que hereda de Carta)
├── CartaFigura.java (Hereda de CartaConPalo)
├── CartaJoker.java (Hereda directamente de Carta)
└── CartaNumeral.java (Hereda de CartaConPalo)


### Cómo Ejecutar

1.  Asegúrate de que todos los archivos `.java` estén organizados en sus respectivos directorios (`baraja/` y `baraja/cartas/`).
2.  Desde la raíz de tu proyecto (la carpeta que contiene el directorio `baraja/`), abre la terminal o línea de comandos y compila las clases:
    ```bash
    javac baraja/*.java baraja/cartas/*.java
    ```
3.  Ejecuta la clase principal:
    ```bash
    java baraja.Principal
    ```
