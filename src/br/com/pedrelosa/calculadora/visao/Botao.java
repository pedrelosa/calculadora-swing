package br.com.pedrelosa.calculadora.visao;

import javax.swing.*;
import java.awt.*;

public class Botao extends JButton {
	public Botao(String texto, Color cor){
		this.setText(texto);
		this.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		this.setOpaque(true);
		this.setBackground(cor);
		this.setForeground(Color.WHITE);
		this.setFocusable(false);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
