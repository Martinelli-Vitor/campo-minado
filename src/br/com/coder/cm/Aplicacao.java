package br.com.coder.cm;

import br.com.coder.cm.model.Tabuleiro;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro (6,6,6);
		
		tabuleiro.alternaMarcacao(4, 4);
		tabuleiro.alternaMarcacao(4, 5);
		tabuleiro.abrir(3, 3);
		
		System.out.println(tabuleiro);
	}

}
