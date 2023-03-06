package br.com.pedrelosa.calculadora.visao;

import br.com.pedrelosa.calculadora.modelo.Memoria;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
	private final JLabel label;
	public Display(){
		setBackground(new Color(46,49,50));
		
		label = new JLabel(Memoria.getInstancia().getTextoAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		
		add(label);
	}
}
