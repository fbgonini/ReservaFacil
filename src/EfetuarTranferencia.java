
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Agendamento de transferencias via pronpt, escreve e le em arquivo.
 * @author Fabio Gonini	
 *
 */
public class EfetuarTranferencia {

	public static void lerTranferencia(String path) throws IOException {
		
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				System.out.println("Transferencias agendadas:");
				System.out.println(linha);

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}

	public static void escreverTranferencia(String path) throws IOException {
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Scanner in = new Scanner(System.in);
		System.out.print("- Conta de origem (padrão XXXXX­X): ");
		linha = in.nextLine();
		buffWrite.append(linha + ";");
		
		System.out.print("- Conta de destino (padrão XXXXX­X): ");
		linha = in.nextLine();
		buffWrite.append(linha + ";");
		
		System.out.print("- Valor da transferencia: ");
		linha = in.nextLine();
		buffWrite.append(linha + ";");
		
		System.out.print("- Data do Agendamento (padrão dd/mm/yyyy): ");
		linha = in.nextLine();
		buffWrite.append(linha + ";");
		
		System.out.print("- Tipo de transferencia (A,B,C ou D): ");
		linha = in.nextLine();
		buffWrite.append(linha + "\n");
		
		buffWrite.close();
	}

}