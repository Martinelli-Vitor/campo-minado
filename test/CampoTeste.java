import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.coder.cm.model.Campo;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	public void iniciarCampo() {
		campo = new Campo (3,3);
	}
	
	@Test
	void testeVizinhoRealDistanciaEsquerda() {
		Campo vizinhoEsquerda = new Campo (3,2);
		boolean resultado = campo.adicionarVizinho(vizinhoEsquerda);
		assertTrue(resultado);	
	}
	
	@Test
	void testeVizinhoRealDistanciaDireita() {
		Campo vizinhoDireita = new Campo (3,4);
		boolean resultado = campo.adicionarVizinho(vizinhoDireita);
		assertTrue(resultado);	
	}
	
	@Test
	void testeVizinhoRealDistanciaCima() {
		Campo vizinhoCima = new Campo (2,3);
		boolean resultado = campo.adicionarVizinho(vizinhoCima);
		assertTrue(resultado);	
	}
	
	@Test
	void testeVizinhoRealDistanciaBaixo() {
		Campo vizinhoBaixo = new Campo (4,3);
		boolean resultado = campo.adicionarVizinho(vizinhoBaixo);
		assertTrue(resultado);	
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo (2,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);	
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo (1,1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);	
	}

}
