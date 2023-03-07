package br.com.pedrelosa.calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	public enum TipoComando{
		ZERAR, NUMERO, DIVISAO, MULTIPLICACAO, SUBTRACAO, SOMA, IGUAL, VIRGULA
	}
	private static final Memoria instancia = new Memoria();
	private final List<MemoriaObservador> observadores = new ArrayList<>();
	private String textoAtual = "";
	private Memoria(){
	
	}
	
	public static Memoria getInstancia(){
		return instancia;
	}
	public void adicionarObservadores(MemoriaObservador observador){
		observadores.add(observador);
	}
	public String getTextoAtual(){
		return this.textoAtual.isEmpty() ? "0": this.textoAtual;
	}
	public void procecarComando(String texto){
		TipoComando tipoComando = detectarTipoComando(texto);
		System.out.println(tipoComando);
		
		this.textoAtual += texto;
		
		this.observadores.forEach(o -> o.valorAlterado(this.getTextoAtual()));
	}
	
	private TipoComando detectarTipoComando(String texto) {
		
		if (this.textoAtual.isEmpty() && texto.equals("0")){
			return null;
		}
		
		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		}catch (NumberFormatException e){
			
			if (texto.equals("AC")){
				return TipoComando.ZERAR;
			}else if (texto.equals("÷")){
				return TipoComando.DIVISAO;
			}else if (texto.equals("*")){
				return TipoComando.MULTIPLICACAO;
			}else if (texto.equals("-")){
				return TipoComando.SUBTRACAO;
			}else if (texto.equals("+")){
				return TipoComando.SOMA;
			}else if (texto.equals("=")){
				return TipoComando.IGUAL;
			}else if (texto.equals(",")){
				return TipoComando.VIRGULA;
			}
		}
		
		return null;
	}
}
