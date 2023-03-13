package br.com.pedrelosa.calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	public enum TipoComando {
		ZERAR, NUMERO, DIVISAO, MULTIPLICACAO, SUBTRACAO, SOMA, IGUAL, VIRGULA
	}
	
	private static final Memoria instancia = new Memoria();
	private final List<MemoriaObservador> observadores = new ArrayList<>();
	
	private TipoComando ultimaOperacao = null;
	private boolean substituir = false;
	private String textoAtual = "";
	private String textoBuffer = "";
	
	private Memoria() {
	
	}
	
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public void adicionarObservadores(MemoriaObservador observador) {
		observadores.add(observador);
	}
	public String getTextoAtual(){
		return this.textoAtual.isEmpty() ? "0": this.textoAtual;
	}
	public void procecarComando(String texto) {
		TipoComando tipoComando = detectarTipoComando(texto);
		System.out.println(tipoComando);
		
		if (tipoComando == null) {
			return;
		} else if (tipoComando == TipoComando.ZERAR) {
			this.textoAtual = "";
			this.textoBuffer = "";
			this.substituir = false;
			this.ultimaOperacao = null;
		} else if (tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.VIRGULA) {
			this.textoAtual = this.substituir ? texto : this.textoAtual + texto;
			this.substituir = false;
		}else {
			this.substituir = true;
			this.textoAtual = obterResultadoOperacao();
			this.textoBuffer = this.textoAtual;
			this.ultimaOperacao = tipoComando;
		}
		
		this.observadores.forEach(o -> o.valorAlterado(this.getTextoAtual()));
	}
	
	private String obterResultadoOperacao() {
		if (this.ultimaOperacao == null) return this.textoAtual;
		
		double numeroBuffer = Double.parseDouble(this.textoBuffer.replace(',', '.'));
		double numeroAtual = Double.parseDouble(this.textoAtual.replace(',', '.'));
		
		double resultado = 0;
		
		switch (this.ultimaOperacao){
			case SOMA -> resultado = numeroBuffer + numeroAtual;
			case SUBTRACAO -> resultado = numeroBuffer - numeroAtual;
			case MULTIPLICACAO -> resultado = numeroBuffer * numeroAtual;
			case DIVISAO -> resultado = numeroBuffer / numeroAtual;
		}
		
		String resultadoString = Double.toString(resultado).replace('.', ',');
		boolean isInteger = resultadoString.endsWith(",0");
		System.out.println(isInteger);
		
		return isInteger ? resultadoString.replace(",0", "") : resultadoString;
	}
	
	private TipoComando detectarTipoComando(String texto) {
		
		if (this.textoAtual.isEmpty() && texto.equals("0")){
			return null;
		}
		
		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		}catch (NumberFormatException e){
			
			switch (texto) {
				case "AC" -> {
					return TipoComando.ZERAR;
				}
				case "÷" -> {
					return TipoComando.DIVISAO;
				}
				case "*" -> {
					return TipoComando.MULTIPLICACAO;
				}
				case "-" -> {
					return TipoComando.SUBTRACAO;
				}
				case "+" -> {
					return TipoComando.SOMA;
				}
				case "=" -> {
					return TipoComando.IGUAL;
				}
				case "," -> {
					if (!this.textoAtual.contains(","))	return TipoComando.VIRGULA;
				}
			}
		}
		
		return null;
	}
}
