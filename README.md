¡Excelente adición! El downcasting es un concepto importante relacionado con el polimorfismo. Aquí tienes el README.md actualizado incluyendo la explicación del downcasting en ambos ejercicios.

Ejercicios de Java Orientados a Objetos
Este repositorio contiene dos ejercicios de programación en Java diseñados para ilustrar y practicar los fundamentos de la Programación Orientada a Objetos (POO), prestando especial atención a conceptos clave como la herencia, el polimorfismo y el downcasting.

Ejercicio 1: Concesionaria de Vehículos
Este ejercicio simula el funcionamiento de una concesionaria de vehículos. El objetivo principal es demostrar cómo se pueden modelar objetos del mundo real utilizando principios de la POO, como la herencia para establecer relaciones "es un" y el polimorfismo para manejar objetos de diferentes tipos de manera uniforme.

Conceptos de POO Aplicados:
Clases y Objetos: Representamos entidades como Vehiculo, Auto, Moto y Concesionaria como clases, y sus instancias como objetos.
Encapsulación: Las propiedades de las clases (ej. marca, modelo, patente) son privadas y se accede a ellas a través de métodos públicos (getters y setters), controlando así el acceso y la modificación de los datos.
Herencia:
La clase Vehiculo es una clase abstracta que define un contrato común para todos los vehículos. Contiene atributos y métodos generales (como acelerar(), frenar(), encender()) que son comunes a cualquier tipo de vehículo.
Las clases Auto y Moto heredan de Vehiculo. Esto significa que un Auto "es un" Vehiculo y una Moto también "es un" Vehiculo". Al heredar,AutoyMotoautomáticamente adquieren las propiedades y comportamientos definidos enVehiculoy pueden añadir sus propias características específicas (ej.tieneAireenAuto,anchoDeManubrioenMoto) y comportamientos únicos (ej.prenderAire()enAuto,hacerWheelie()enMoto`). Esto promueve la reutilización de código y establece una jerarquía lógica.
Polimorfismo:
La clase Concesionaria tiene un ArrayList<Vehiculo>, lo que significa que puede almacenar objetos de tipo Vehiculo, Auto, Moto o cualquier otra subclase de Vehiculo.
Cuando se llama al método agregarVehiculo(Vehiculo v), se puede pasar una instancia de Auto o de Moto. El sistema de tipos de Java permite que una referencia de tipo Vehiculo apunte a objetos de sus subclases. Esta capacidad de un objeto de tomar muchas formas (polimorfismo significa "muchas formas") es crucial para diseñar sistemas flexibles y extensibles. Por ejemplo, en el futuro podríamos añadir una clase Camion que también herede de Vehiculo, y la Concesionaria podría agregar camiones sin necesidad de modificar su código.
Downcasting (Casting Descendente):
En este ejercicio, aunque no se implementa explícitamente en el código proporcionado, el downcasting sería necesario si quisiéramos acceder a un método o atributo específico de una subclase desde una referencia de su superclase.
Por ejemplo, si recuperamos un Vehiculo de la ArrayList de la Concesionaria, este será de tipo Vehiculo. Para llamar a prenderAire() (que es exclusivo de Auto) o hacerWheelie() (exclusivo de Moto), primero debemos verificar si el objeto es realmente de ese tipo específico y luego realizar un downcasting.
Ejemplo conceptual de downcasting:
Java

// Suponiendo que 'vehiculos' es el ArrayList<Vehiculo> de la Concesionaria
for (Vehiculo v : concesionaria.getVehiculos()) { // Iteramos como Vehiculo
    if (v instanceof Auto) { // Verificamos si es un Auto
        Auto auto = (Auto) v; // Realizamos el downcasting
        auto.prenderAire();    // Ahora podemos llamar al método específico de Auto
    } else if (v instanceof Moto) { // Verificamos si es una Moto
        Moto moto = (Moto) v;   // Realizamos el downcasting
        moto.hacerWheelie();    // Ahora podemos llamar al método específico de Moto
    }
    v.acelerar(); // Este método es polimórfico, se llama directamente sobre la referencia Vehiculo
}
Es importante usar instanceof antes de realizar un downcasting para evitar una ClassCastException si el objeto no es del tipo esperado. El downcasting debe usarse con precaución, ya que a menudo un buen diseño polimórfico puede reducir su necesidad.
Estructura del Código:
Java

// Clase abstracta base
public abstract class Vehiculo {
    // Atributos comunes
    protected String marca;
    protected String modelo;
    protected String patente;

    // Métodos comunes
    public void acelerar() { /* ... */ }
    public void frenar() { /* ... */ }
    public void encender() { /* ... */ }
    // ...
}

// Subclase de Vehiculo
public class Auto extends Vehiculo {
    private boolean tieneAire;

    public Auto(boolean tieneAire, String marca, String modelo, String patente) {
        super(marca, modelo, patente); // Llama al constructor de la clase padre
        this.tieneAire = tieneAire;
    }

    public void prenderAire() { /* ... */ } // Método específico de Auto
}

// Subclase de Vehiculo
public class Moto extends Vehiculo {
    private int anchoDeManubrio;

    public Moto(int anchoDeManubrio, String marca, String modelo, String patente) {
        super(marca, modelo, patente); // Llama al constructor de la clase padre
        this.anchoDeManubrio = anchoDeManubrio;
    }

    public void hacerWheelie() { /* ... */ } // Método específico de Moto
}

// Clase que utiliza el polimorfismo
public class Concesionaria {
    private ArrayList<Vehiculo> vehiculos; // Puede contener Autos, Motos, etc.

    public void agregarVehiculo(Vehiculo v) { // Acepta cualquier Vehiculo
        this.vehiculos.add(v);
    }
}
Cómo ejecutar:
Asegúrate de que todos los archivos .java ( Auto.java, Concesionaria.java, Moto.java, Principal.java, Vehiculo.java) estén en el mismo directorio.
Compila las clases desde tu terminal: javac *.java
Ejecuta la clase principal: java Principal
Ejercicio 2: Baraja de Cartas Inglesa
Este ejercicio se enfoca en la creación de una baraja de cartas inglesa, utilizando la herencia para estructurar los diferentes tipos de cartas y el polimorfismo para manejarlas de forma unificada.

Conceptos de POO Aplicados:
Clases y Objetos: Modelamos Carta, CartaNumeral, CartaFigura, CartaJoker y la BarajaInglesa como clases.
Encapsulación: Las propiedades internas de cada carta (ej. tapada, numero, letra) se mantienen privadas y se gestionan mediante el comportamiento de la carta.
Herencia:
La clase Carta es la clase base abstracta de la que derivan todos los tipos de cartas. Define características y comportamientos comunes como si la carta está tapada y el método mostrar().
CartaConPalo es una clase abstracta intermedia que hereda de Carta. Sirve para agrupar todas las cartas que tienen un Palo (como las cartas numéricas y de figura).
CartaNumeral y CartaFigura heredan de CartaConPalo. Esto les permite tener un Palo y añadir sus propias características específicas (un numero para CartaNumeral o una letra para CartaFigura).
CartaJoker hereda directamente de Carta ya que los Jokers no tienen un palo tradicional. Esta jerarquía demuestra cómo la herencia puede modelar relaciones complejas donde algunas subclases comparten una base común, pero otras tienen características muy distintas que justifican una rama de herencia diferente.
Polimorfismo:
La clase BarajaInglesa utiliza un ArrayList<Carta>. Esto es un ejemplo clave de polimorfismo, ya que la lista puede contener cualquier tipo de objeto que sea una Carta o una de sus subclases ( CartaNumeral, CartaFigura, CartaJoker).
Cuando se itera sobre la lista de cartas en BarajaInglesa para llamar al método mostrar(), cada objeto individual (CartaNumeral, CartaFigura o CartaJoker) ejecutará su propia implementación específica de mostrar(). Aunque la referencia es de tipo Carta, el comportamiento real se determina en tiempo de ejecución según el tipo de objeto concreto al que se esté haciendo referencia. Esto permite manejar todos los tipos de cartas de forma genérica sin necesidad de escribir código condicional para cada tipo.
Downcasting (Casting Descendente):
Similar al ejercicio anterior, el downcasting sería necesario si, por ejemplo, quisiéramos acceder al numero específico de una CartaNumeral o al letra de una CartaFigura cuando estamos iterando la lista como ArrayList<Carta>.
Ejemplo conceptual de downcasting:
Java

// Suponiendo que 'cartas' es el ArrayList<Carta> de la BarajaInglesa
for (Carta carta : baraja.getCartas()) {
    if (carta instanceof CartaNumeral) {
        CartaNumeral numeral = (CartaNumeral) carta;
        // Ahora podemos acceder a numeral.getNumero() si existiera ese getter
        System.out.println("Es una carta numeral: " + numeral);
    } else if (carta instanceof CartaFigura) {
        CartaFigura figura = (CartaFigura) carta;
        // Acceder a figura.getLetra()
        System.out.println("Es una carta de figura: " + figura);
    } else if (carta instanceof CartaJoker) {
        CartaJoker joker = (CartaJoker) carta;
        // Acceder a joker.isAColor()
        System.out.println("Es un Joker: " + joker);
    }
    carta.mostrar(); // Esto usa el polimorfismo sin downcasting
}
El downcasting nos permite "bajar" en la jerarquía de herencia y tratar un objeto como un tipo más específico, habilitando el acceso a sus métodos y propiedades únicas. Sin embargo, siempre debe ir precedido de una verificación con instanceof para garantizar la seguridad de tipo en tiempo de ejecución.
Estructura del Código:
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
Cómo ejecutar:
Asegúrate de que todos los archivos .java estén organizados en sus respectivos directorios (baraja/ y baraja/cartas/).
Desde la raíz del proyecto (la carpeta que contiene baraja/), compila las clases: javac baraja/*.java baraja/cartas/*.java
Ejecuta la clase principal: java baraja.Principal
