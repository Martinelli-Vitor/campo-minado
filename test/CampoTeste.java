import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.coder.cm.exception.ExplosaoException;
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
	
	@Test
	public void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	public void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	public void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	public void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	public void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	public void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	public void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, ()->{
			campo.abrir();
		});
	}
	
	@Test
	public void testeAbrirComVizinhos() {
		Campo campo22 = new Campo (2,2);
		Campo campo11 = new Campo (1,1);
		
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());	
	}
	
	@Test
	public void testeAbrirComVizinhos2() {
		Campo campo22 = new Campo (2,2);
		Campo campo11 = new Campo (1,1);
		Campo campo12 = new Campo(1,1);
		campo12.minar();
		
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && !campo11.isAberto());	
	}

}
