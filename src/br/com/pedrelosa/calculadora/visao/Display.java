package br.com.pedrelosa.calculadora.visao;

import br.com.pedrelosa.calculadora.modelo.Memoria;
import br.com.pedrelosa.calculadora.modelo.MemoriaObservador;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements MemoriaObservador {
	private final JLabel label;
	public Display(){
		Memoria.getInstancia().adicionarObservadores(this);
		
		this.setBackground(new Color(46,49,50));
		
		this.label = new JLabel(Memoria.getInstancia().getTextoAtual());
		this.label.setForeground(Color.WHITE);
		this.label.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		
		this.add(label);
	}
	
	@Override
	public void valorAlterado(String novoValor) {
		this.label.setText(novoValor);
	}
}
