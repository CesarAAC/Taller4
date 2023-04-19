package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;

public class InterfazTablero extends JPanel implements MouseListener {
	
   private Rectangle[][] rectangles;
   private int[][] oprimidos;
   private Tablero juego;
   private int tamaño;
   private Graphics g;

   public InterfazTablero(int tamaño) {
	   this.tamaño=tamaño;
	   setSize(tamaño*50, tamaño*50);
	   rectangles = new Rectangle[tamaño][tamaño];
	   oprimidos = new int[tamaño][tamaño];
	   juego= new Tablero(tamaño);
	   for (int x = 0; x < (tamaño); x++) {
			for (int y = 0; y < (tamaño); y++) {
				rectangles[x][y]= new Rectangle((x*50),(y*50),50,50);
				oprimidos[x][y]= 0;
			}
	   }
      
      addMouseListener(this);
   }

   public void paintComponent(Graphics g) {
	   this.g=g;
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      boolean[][] tableroBoleano=juego.darTablero();
      for(int x=0; x<tamaño;x++) {
    	  for(int y=0;y<tamaño;y++) {
    		  if (tableroBoleano[x][y]) {
    			  g2.setColor(Color.black);
    			  g2.fill(rectangles[x][y]);
    		  }
    		  else {
    			  g2.setColor(Color.yellow);
    			  g2.fill(rectangles[x][y]);
    		  }

    	  }
      }
   }

   public void mouseClicked(MouseEvent e) {
      int x = e.getX();
      int y = e.getY();
      for (Rectangle[] rect : rectangles) {
    	  for (Rectangle rect2 : rect) {
    		  if (rect2.contains(x, y)) {
    			  oprimidos[(x/50)][(y/50)]+=1;
    			  System.out.println(oprimidos[(x/50)][(y/50)]);
    			  System.out.println("Click en el rectángulo " + rect2.getLocation());
    			  juego.jugar((x/50),(y/50));
    			  repaint();
    			  paintComponent(g);
         }
    	}
      }
   }

   public void mousePressed(MouseEvent e) {}
   public void mouseReleased(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}

}