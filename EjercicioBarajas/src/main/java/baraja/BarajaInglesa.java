/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baraja;


import baraja.cartas.Carta;
import baraja.cartas.CartaFigura;
import baraja.cartas.CartaJoker;
import baraja.cartas.CartaNumeral;
import java.util.ArrayList;

/**
 *
 * @author brizu
 */
public class BarajaInglesa {
    private ArrayList<Carta>cartas;

    public BarajaInglesa() {
        this.cartas =  new ArrayList<>();
        generarCartas();
        System.out.println(cartas.size());
    }
    
    public void mostrarBaraja(){
        for (Carta carta : cartas) {
            carta.mostrar();
            
        }
    }
    private void generarCartas(){
        GenerarCartasNaturales();
        GenerarCartasFiguras();
        GenerarCartasJokers();
    }

    private void GenerarCartasNaturales() {
      final int MIN_VALOR=2;
      final int MAX_VALOR=10;
      Palo[] palos=Palo.values();
        for (int p= 0; p < palos.length; p++) {
            Palo paloAct=palos[p];
            for (int i = MIN_VALOR; i <=MAX_VALOR; i++) {
            this.cartas.add(new  CartaNumeral(i,paloAct));
            
        }
        }
        
    }

    private void GenerarCartasFiguras() {
        char[] letras = {'A','J','Q','K'};
        Palo[] palos= Palo.values();
           for (int p= 0; p < palos.length; p++) {
            Palo  PaloActual=palos[p];
            for (int i = 0; i <letras.length; i++) {
                char letraActual=letras[i];
            this.cartas.add(new  CartaFigura(letraActual,PaloActual));
            
        }
        }
      }

    private void GenerarCartasJokers() {
        this.cartas.add(new CartaJoker(true));
        this.cartas.add(new CartaJoker(false));
         }
}
