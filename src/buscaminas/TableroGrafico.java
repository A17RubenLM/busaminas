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


import static buscaminas.Buscaminas.tablero;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Boton extends JButton{
    Boton(){
        setBackground(new Color(40,24,221));
    }

}
class TableroGrafico extends JFrame{
    static Boton[][] ArrayBotones =new Boton[InterfazJugador.dimensionesTablero][InterfazJugador.dimensionesTablero];
    int casillasReveladas=0;
    void Revelar (int i, int j){
        ArrayBotones[i][j].setText(String.valueOf(Buscaminas.tablero[i][j]));  
        ArrayBotones[i][j].setEnabled(false);
        ArrayBotones[i][j].setBackground(Color.YELLOW);
        if(Buscaminas.tablero[i][j]==9){
            ArrayBotones[i][j].setBackground(Color.RED);
            for(int y=0;y<InterfazJugador.dimensionesTablero;y++){
                for(int z=0;z<InterfazJugador.dimensionesTablero;z++){
                    if (ArrayBotones[y][z].isEnabled()){
                        ArrayBotones[y][z].setBackground(Color.GRAY);
                        ArrayBotones[y][z].setText(String.valueOf(Buscaminas.tablero[y][z]));
                        ArrayBotones[y][z].setEnabled(false);
                        setTitle("BOOOOOOOOOOOM");
                    }
                }
            }    
        }
        
        if (Buscaminas.tablero[i][j]==0){
            for(int f = Math.max(0, i-1); f < Math.min(tablero.length, i+2); f++){
                for(int c = Math.max(0, j-1); c < Math.min(tablero.length, j+2); c++){
                    if (f!=i && c!=j){
                        /*casillasReveladas++;
                        if (casillasReveladas==(InterfazJugador.dimensionesTablero*InterfazJugador.dimensionesTablero-InterfazJugador.numeroMinas)){
                            for(int y=0;y<InterfazJugador.dimensionesTablero;y++){
                                for(int z=0;z<InterfazJugador.dimensionesTablero;z++){
                                    if (ArrayBotones[y][z].isEnabled()){
                                        ArrayBotones[y][z].setBackground(Color.GREEN);
                                        ArrayBotones[y][z].setText(String.valueOf(Buscaminas.tablero[y][z]));
                                        ArrayBotones[y][z].setEnabled(false);
                                        setTitle("¡¡VICTORIA!!");
                                    }
                                }
                            }
                        }*/
                        Revelar(f,c);   
                    }    
                }
            }
        } 
        
        
    }
    
    private ActionListener Pulsar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i=0;i<InterfazJugador.dimensionesTablero;i++){
                for (int j=0; j<InterfazJugador.dimensionesTablero;j++){
                    if(e.getSource()==ArrayBotones[i][j]){
                        Revelar(i,j);
                    }
                }    
            }
                       
        }
       
    };
    public TableroGrafico(){   
        super("Buscaminas");   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(InterfazJugador.dimensionesTablero,InterfazJugador.dimensionesTablero));
        setPreferredSize(new Dimension(500,500));
        for(int i=0;i<InterfazJugador.dimensionesTablero;i++){
            for(int j=0;j<InterfazJugador.dimensionesTablero;j++){
                Boton bot = new Boton ();
                bot.addActionListener(Pulsar);
                ArrayBotones[i][j]=bot;
                add(bot);
            }
        }
        setVisible(true);
        pack();
    }
        
    
}