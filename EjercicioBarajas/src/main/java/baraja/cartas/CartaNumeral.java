/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baraja.cartas;

import baraja.Palo;

/**
 *
 * @author brizu
 */
public class CartaNumeral extends CartaConPalo{
    private int numero;

    public CartaNumeral(int numero, Palo palo) {
        super(palo);
        this.numero = numero;
    }

    public CartaNumeral(Palo palo) {
        super(palo);
    }
}
