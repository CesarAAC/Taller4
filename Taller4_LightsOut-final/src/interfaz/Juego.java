package interfaz;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Juego extends JFrame implements ActionListener{
	static Scanner input= new Scanner(System.in);
	private InterfazTablero interfazTablero;
	public Container container;
	
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container= getContentPane();
		container.setLayout(new GridBagLayout());
		container.setVisible(true);
		
		// lateral//
		setTitle("Ejemplo Swing");
	    setSize(1500, 1500);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    JPanel menu = new JPanel();
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		JButton nuevo= new JButton("nuevo");
		nuevo.setVisible(true);
		JButton reiniciar= new JButton("reiniciar");
		reiniciar.setVisible(true);
		JButton top=new JButton("Top-10");
		top.setVisible(true);
		JButton cambiar= new JButton("cambiar jugador");
		cambiar.setVisible(true);
		menu.add(nuevo);
		menu.add(reiniciar);
		menu.add(top);
		menu.add(cambiar);
		menu.setVisible(true);
		
		//Tablero del juego//
		System.out.println("De que tamaño desea que sea el juego:");
		int tamaño= Integer.parseInt(input.next());
		InterfazTablero interfazTablero=new InterfazTablero(tamaño);
		
		
		//Menu superior//
		JPanel superior = new JPanel();
        Color lateralColor = new Color(50, 50, 255);
        superior.setBackground(lateralColor);
        superior.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel tamañoJLabel = new JLabel("Tamaño:");
        superior.add(tamañoJLabel);
        String[] optionsTamaño = {"3x3", "5x5"};
        JComboBox<String> jComboBox = new JComboBox<>(optionsTamaño);
        superior.add(jComboBox);
        JLabel dificultadJLabel = new JLabel("Dificultad:");
        superior.add(dificultadJLabel);

        ButtonGroup dificultadOpciones = new ButtonGroup();
        JRadioButton facilButton = new JRadioButton();
        JRadioButton medioButton = new JRadioButton();
        JRadioButton dificilButton = new JRadioButton();

        dificultadOpciones.add(facilButton);
        dificultadOpciones.add(medioButton);
        dificultadOpciones.add(dificilButton);

        superior.add(facilButton);
        superior.add(medioButton);
        superior.add(dificilButton);
        
        //Inferior//
        
		
		
		
		
		
		
		
		
		
		
		//Organizacion de todo//
        
		//Arriba//
		GridBagConstraints arriba= new GridBagConstraints();
		arriba.anchor= GridBagConstraints.CENTER;
		arriba.fill=GridBagConstraints.HORIZONTAL;
		arriba.gridx=0;
		arriba.gridy=10;
		arriba.weightx=1;
		container.add(superior, arriba);
		//tablero//
		GridBagConstraints tablerojuego= new GridBagConstraints();
		tablerojuego.anchor= GridBagConstraints.CENTER;
		tablerojuego.fill=GridBagConstraints.BOTH;
		tablerojuego.gridx=0;
		tablerojuego.gridy=11;
		tablerojuego.weightx=1;
		tablerojuego.weighty=1;
		container.add(interfazTablero, tablerojuego);
		//lateral//
		GridBagConstraints lateral= new GridBagConstraints();
		lateral.anchor= GridBagConstraints.CENTER;
		lateral.fill=GridBagConstraints.BOTH;
		lateral.gridx=2;
		lateral.gridy=11;
		lateral.weightx=1;
		lateral.weighty=1;
		container.add(menu, lateral);
	}
	
public static void main(String[] args) throws Exception {
	Juego juego= new Juego(); 
	juego.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}