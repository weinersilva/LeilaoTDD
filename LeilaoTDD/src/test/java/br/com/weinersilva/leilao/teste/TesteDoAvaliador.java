package br.com.weinersilva.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.weinersilva.leilao.dominio.Lance;
import br.com.weinersilva.leilao.dominio.Leilao;
import br.com.weinersilva.leilao.dominio.Usuario;
import br.com.weinersilva.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	@Test
	public void deveEntenderLancesEnOrdemCrescente() {
		Usuario joao = new Usuario("Jo�o");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 4 Novo");
		
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
}
