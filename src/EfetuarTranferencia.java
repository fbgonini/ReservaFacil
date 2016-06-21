
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
		System.out.println("\n  ::  Transferencias agendadas  ::  ");
		while (true) {
			if (linha != null) {
				System.out.println(linha);
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}

	public static void escreverTranferencia(String path) throws IOException {
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		obterTransferencia(buffWrite);
		String str = new String();
		
        do {
        	System.out.print("\n Deseja efetuar outro agengamento ( S ou N ):");
            str = br.readLine();
            if("S".equals(str)){
            	obterTransferencia(buffWrite);
            }
		} while ("S".equals(str));
		
		buffWrite.close();
	}

	private static void obterTransferencia(BufferedWriter buffWrite) throws IOException {
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
	}

}