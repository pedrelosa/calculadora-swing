package br.com.pedrelosa.calculadora.visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teclado extends JPanel implements ActionListener {
	private final Color COR_CINZA_ESCURO = new Color(68,68,68);
	private final Color COR_CINZA_CLARO = new Color(99,99,99);
	private final Color COR_LARANJA = new Color(242,163,60);
	public Teclado(){
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		this.setLayout(layout);
		
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		//Linha 1
		c.gridwidth = 3;
		adicionarBotao("AC", this.COR_CINZA_ESCURO, c, 0, 0);
		c.gridwidth = 1;
		adicionarBotao("÷", this.COR_LARANJA, c, 3, 0);
		
		//Linha 2
		adicionarBotao("7", this.COR_CINZA_CLARO, c, 0, 1);
		adicionarBotao("8", this.COR_CINZA_CLARO, c, 1, 1);
		adicionarBotao("9", this.COR_CINZA_CLARO, c, 2, 1);
		adicionarBotao("*", this.COR_LARANJA, c, 3, 1);
		
		//Linha 3
		adicionarBotao("4", this.COR_CINZA_CLARO, c, 0, 2);
		adicionarBotao("5", this.COR_CINZA_CLARO, c, 1, 2);
		adicionarBotao("6", this.COR_CINZA_CLARO, c, 2, 2);
		adicionarBotao("-", this.COR_LARANJA, c, 3, 2);
		
		//Linha 4
		adicionarBotao("1", this.COR_CINZA_CLARO, c, 0, 3);
		adicionarBotao("2", this.COR_CINZA_CLARO, c, 1, 3);
		adicionarBotao("3", this.COR_CINZA_CLARO, c, 2, 3);
		adicionarBotao("+", this.COR_LARANJA, c, 3, 3);
		
		//Linha 5
		c.gridwidth = 2;
		adicionarBotao("0", this.COR_CINZA_CLARO, c, 0, 4);
		c.gridwidth = 1;
		adicionarBotao(",", this.COR_CINZA_CLARO, c, 2, 4);
		adicionarBotao("=", this.COR_LARANJA, c, 3, 4);
		
	}
	
	private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		
		c.gridx = x;
		c.gridy = y;
		this.add(botao, c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton botaoRecebido){
			System.out.println(botaoRecebido.getText());
		}
	}
}
