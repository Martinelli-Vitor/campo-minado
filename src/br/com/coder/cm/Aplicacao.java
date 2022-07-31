package br.com.coder.cm;

import br.com.coder.cm.model.Tabuleiro;
import br.com.coder.cm.view.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro (6,6,6);
		
		new TabuleiroConsole(tabuleiro);
		
		
	}

}
