package gerenciador.telas.ultilidades;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Data {
    public String mes, dia, ano, dia_semana, hora;
    SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm:ss");

    public static String mostraData() {

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = hoje.format(formatador);
        return data;
    }

    public static String mostraHora() throws InterruptedException {

        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("HH':'mm':'ss", locale);
        String hora = (formatador.format(calendar.getTime()));
        return hora;
    }

    public static String mostraHoraData() {
        Locale locale = new Locale("pt", "BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy  HH':'mm':'ss", locale);
        String hora = (formatador.format(calendar.getTime()));
        System.out.println(hora);
        return hora;
    }

    public void le_hora()
    {
        Date horaAtual = new Date();
        hora = horaformatada.format(horaAtual);
    }
      

           
    public void le_data()
    {
        mes = "" + Calendar.MONTH;
        dia = "" + Calendar.DAY_OF_MONTH;
        ano = "" + Calendar.YEAR;
   
    }
}        
