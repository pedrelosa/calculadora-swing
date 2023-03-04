package br.com.pedrelosa.calculadora.visao;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {
	public Calculadora(){
		
		this.setSize(232,322);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.organizarLayout();
		
		this.setVisible(true);
	}
	
	private void organizarLayout() {
		this.setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233, 60));
		this.add(display, BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		this.add(teclado, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new Calculadora();
	}
	
}
