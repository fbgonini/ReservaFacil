import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class DefinirTaxasTester {

	@Test
	public void testOperacao_TipoA() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setTipoTransacao( t.TipoTransacao.A );
		
		DefinirTaxas.Definir(t);
		assertTrue(t.getTaxa() == 32);
	}
	
	@Test
	public void testOperacao_TipoB_30_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 1, 31));
		t.setTipoTransacao( t.TipoTransacao.B );
		
		DefinirTaxas.Definir(t);
		assertTrue(t.getTaxa() == 10);
		
	}
	
	@Test
	public void testOperacao_TipoB_mais_de_30_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 2, 15));
		t.setTipoTransacao( t.TipoTransacao.B );
		
		DefinirTaxas.Definir(t);
		assertTrue(t.getTaxa() == 8);
	}

	
	@Test
	public void testOperacao_TipoC_mais_de_30_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 2, 15));
		t.setTipoTransacao( t.TipoTransacao.C );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 12);
	}
	
	@Test
	public void testOperacao_TipoC_ate_30_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 1, 29));
		t.setTipoTransacao( t.TipoTransacao.C );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 21);
	}
	
	@Test
	public void testOperacao_TipoC_ate_25_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 1, 24));
		t.setTipoTransacao( t.TipoTransacao.C );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 43);
	}
	
	
	@Test
	public void testOperacao_TipoC_ate_20_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 1, 19));
		t.setTipoTransacao( t.TipoTransacao.C );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 54);
	}
	
	@Test
	public void testOperacao_TipoC_ate_15_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 1, 14));
		t.setTipoTransacao( t.TipoTransacao.C );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 67);
	}
	
	@Test
	public void testOperacao_TipoC_ate_10_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 1, 10));
		t.setTipoTransacao( t.TipoTransacao.C );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 74);
	}
	
	@Test
	public void testOperacao_TipoC_ate_5_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(1000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 1, 2));
		t.setTipoTransacao( t.TipoTransacao.C );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 83);
	}
	
	@Test
	public void testOperacao_TipoD_ate_25000() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(10000.0);
		t.setTipoTransacao( t.TipoTransacao.D );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 302);
	}
	
	@Test
	public void testOperacao_TipoD_30000_10_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(30000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 1, 11));
		t.setTipoTransacao( t.TipoTransacao.D );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 10);
	}
	
	@Test
	public void testOperacao_TipoD_30000_40_dias() throws Exception {
		
		Transferencia t = new Transferencia();
		t.setValor(30000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 2, 9));
		t.setTipoTransacao( t.TipoTransacao.D );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 8);
	}
	
	@Test
	/**
	 * Nao é necessario testes TIPO D acima de 120.000 para as variacoes de tarifa TIPO C
	 * Foi escolhida a variacao acima de 30 dias
	 */
	public void testOperacao_TipoD_200000_mais_de_30_dias() throws Exception {

		Transferencia t = new Transferencia();
		t.setValor(200000.0);
		t.setDataCadastro(new Date(2016, 1, 1));
		t.setDataAgendada(new Date(2016, 3, 9));
		t.setTipoTransacao( t.TipoTransacao.D );
		
		DefinirTaxas.Definir(t);
		
		assertTrue(t.getTaxa() == 2400);
	}
}
