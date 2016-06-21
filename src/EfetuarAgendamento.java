import java.io.IOException;
import java.text.ParseException;

/**
 * Classe que testa o agendamento de transferencias via pronpt, escreve e le em arquivo.
 * @author Fabio Gonini
 */
public class EfetuarAgendamento {

	public static void EfetuarAgendamento() throws IOException {
		
		String path = "C:/Users/Fabio/workspace/ReservaFacil/agendamentos.txt";

		System.out.println("   :: Agendar Transferencia :: \n");
		EfetuarTranferencia.escreverTranferencia(path);
		EfetuarTranferencia.lerTranferencia(path);

	}
	
	public static void main(String[] args) throws IOException, ParseException {
		
		EfetuarAgendamento();
	}


}
