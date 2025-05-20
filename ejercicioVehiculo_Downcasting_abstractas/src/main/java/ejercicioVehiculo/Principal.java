/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioVehiculo;

/**
 *
 * @author brizu
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Concesionaria c = new Concesionaria();
        Auto a = new Auto(true, "MarcaFalsa", "XYZ", "ABC123");
        Vehiculo v = a;
        c.agregarVehiculo(a);
        c.agregarVehiculo(new Moto(20, "OtraMarca", "XHT", "BCD234"));

        new Object();
    }

    
}
