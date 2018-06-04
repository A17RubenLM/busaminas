/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;


import java.util.Scanner;
import javax.swing.JFrame;

public class InterfazJugador {
    static int dimensionesTablero;
    static int numeroMinas;   
    static Buscaminas juego;  
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        System.out.println("BUSCAMINAS");
        System.out.println();
        System.out.println();
        System.out.println("Introduce datos del juego: ");
        System.out.print("\nDimensiones: ");
        dimensionesTablero = scan.nextInt();
        System.out.print("\nNúmero de minas: ");
        numeroMinas= scan.nextInt();  
        juego = new Buscaminas(dimensionesTablero, numeroMinas);
        TableroGrafico pruebaJFrame = new TableroGrafico();      
    }
    
}