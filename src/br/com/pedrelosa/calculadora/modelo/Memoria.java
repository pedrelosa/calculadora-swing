package br.com.pedrelosa.calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
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
	public void procecarComando(String valor){
		this.textoAtual += valor;
		
		this.observadores.forEach(o -> o.valorAlterado(this.getTextoAtual()));
	}
}
