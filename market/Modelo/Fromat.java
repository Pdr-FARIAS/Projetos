package market.Modelo;

import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class Fromat {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    static NumberFormat nf = new DecimalFormat("R$ #,##0.##", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String dateParaSring(Date data) {
        return Fromat.sdf.format(data);
    }
    public static String doubleParaString(Double valor){
        return Fromat.nf.format(valor);
    }

    public static Double stringParaDouble(String valor){
        try{
            return (Double)Fromat.nf.parse(valor);
        } catch (ParseException e) {
            return null;
        }
    }
    public static void pausar(int segundos){
        try{
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            System.out.println("Erro ao parar o sistema");
        }
    }



}
