import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

public class DefinirTaxas {

	public static void Definir( Transferencia t) throws ParseException {

		switch (t.getTipoTransacao()) {
		
		case A :
			calculaTipoA(t);
			break;
		case B :
			calculaTipoB(t);
			break;
		case C :
			calculaTipoC(t);
			break;
		case D :
			if(t.valor <= 25000){
				calculaTipoA(t);
			}else if ( t.valor <= 120000) {
				calculaTipoB(t);
			}else {
				calculaTipoC(t);
			}
			break;
		}
	}

	/**
	 * Operações do tipo C tem uma taxa de:
	 * maior que 30 dias da data de cadastro ­ 1.2%
	 * até 30 dias da data de cadastro ­ 2.1%
	 * até 25 dias da data de cadastro ­ 4.3%
	 * até 20 dias da data de cadastro ­ 5.4%
	 * até 15 dias da data de cadastro ­ 6.7%
	 * até 10 dias da data de cadastro ­ 7.4%
	 * até 5 dias da data de cadastro ­ 8.3%
	 * @param t - Transferencia
	 * @throws ParseException
	 */
	private static void calculaTipoC(Transferencia t) throws ParseException {
		double taxa;
		int diasEntreDatas = diferencaEntreDatas( t.dataCadastro, t.dataAgendada);
		if( diasEntreDatas <= 5 ){
			taxa = t.valor * 0.083;
		}else if( diasEntreDatas <= 10 ){
			taxa = t.valor * 0.074;
		}else if( diasEntreDatas <= 15 ){
			taxa = t.valor * 0.067;
		}else if( diasEntreDatas <= 20 ){
			taxa = t.valor * 0.054;
		}else if( diasEntreDatas <= 25 ){
			taxa = t.valor * 0.043;
		}else if( diasEntreDatas <= 30 ){
			taxa = t.valor * 0.021;
		}else{
			taxa = t.valor * 0.012;
		}
			
		t.setTaxa(taxa);
	}

	/**
	 * Operações do tipo B tem uma taxa de:
	 * $10 para pedidos com agendamento até 30 dias da data de cadastro
     * $8 para os demais
	 * @param t - Transferencia
	 * @throws ParseException
	 */
	private static void calculaTipoB(Transferencia t) throws ParseException {
		
		int diasEntreDatas = diferencaEntreDatas( t.dataCadastro, t.dataAgendada);
		if( diasEntreDatas <= 30 ){
			t.setTaxa(10);
		}else{
			t.setTaxa(8);
		}
	}

	/**
	 * Operações do tipo A tem uma taxa de $2 mais 3% do valor da transferência
	 * @param t - Transferencia
	 */
	private static void calculaTipoA(Transferencia t) {
		double taxa;
		taxa = 2 + ( t.valor * 0.03 );
		t.setTaxa(taxa);
	}
	
    public static int diferencaEntreDatas(Date data1, Date data2) throws ParseException{  
        GregorianCalendar ini = new GregorianCalendar();  
        GregorianCalendar fim = new GregorianCalendar();  
        ini.setTime(data1);  
        fim.setTime(data2);  
        long dt1 = ini.getTimeInMillis();  
        long dt2 = fim.getTimeInMillis();  
        return (int) (((dt2 - dt1) / 86400000));  
    }  

}
