/*Creare una classe Concerto che estende Evento, che ha anche gli attributi :
ora (LocalTime)
prezzo
Aggiungere questi attributi nel costruttore e implementarne getter e setter.
Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€) Fare l’ override 
del metodo toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - 
prezzo formattato
 */

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class Concerto extends Evento {
    private LocalTime ora;
    private double prezzo;

    // Costruttore
    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) throws Eccezione{
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    // Getter e Setter per ora
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    // Getter e Setter per prezzo
    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // Metodo per restituire data e ora formattata
    public String getDataOraFormattata() {
        return getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + 
               ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    // Metodo per restituire prezzo formattato
    public String getPrezzoFormattato() {
        DecimalFormat df = new DecimalFormat("##,##€");
        return df.format(prezzo);
    }

    // Override del metodo toString()
    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}
