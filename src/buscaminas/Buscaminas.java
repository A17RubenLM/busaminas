/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author Rubén
 */
import java.util.Random;

public class Buscaminas {
    static int[][] tablero;
    String[][] tableroOculto;   
    int minas;
    public boolean resuelto = false;
    public boolean derrota = false;
    
    Buscaminas(int dimensiones, int minas){
        this.minas = minas;       
        tablero = new int[dimensiones][dimensiones];
        for(int i = 0; i < dimensiones; i++){
            for(int j = 0; j < dimensiones; j++){
                tablero[i][j] = 0;
            }
        }
        ponerMinas();
    }
    
    void ponerMinas(){
        Random rand = new Random();
        int ancho = tablero.length;
        int alto = tablero.length;
        int minasColocadas = 0;
        while(minasColocadas < minas){
            int x = rand.nextInt(alto);
            int y = rand.nextInt(ancho);
            if(tablero[x][y] != 9){
               tablero[x][y] = 9;
               minasColocadas++;
               for(int f = Math.max(0, x-1); f < Math.min(tablero.length, x+2); f++){
                    for(int c = Math.max(0, y-1); c < Math.min(tablero.length, y+2); c++){
                        if(f==x && c==y){
                            continue;
                        }
                        if(this.tablero[f][c] < 9){
                                this.tablero[f][c] += 1;
                        }
                    }
                }
            }
        }
    }  
    
   public int[][] devolverTablero(){
       return tablero;
   }
}
