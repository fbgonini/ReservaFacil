import java.util.Date;

public class Transferencia {
	
	String contaOrigem;
	String contaDestino;
	double valor;
	double taxa;
	Date dataAgendada;
	Date dataCadastro;
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	TipoTransacao TipoTransacao;
	
	public enum TipoTransacao {
		A(1), B(2), C(3), D(4);
		
		public int numeroTransacao;
		TipoTransacao(int n) {
			numeroTransacao = n;
		}
		public int getNumeroTransacao(){
			return numeroTransacao;
		}
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public Date getDataAgendada() {
		return dataAgendada;
	}

	public void setDataAgendada(Date dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public TipoTransacao getTipoTransacao() {
		return TipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		TipoTransacao = tipoTransacao;
	}

}
