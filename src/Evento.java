/*Stiamo lavorando a un programma che deve gestire eventi (ad esempio concerti, conferenze, spettacoli etc.).

Step 1
Creare una classe Evento che abbia le seguenti proprietà:
titolo
data
numero di posti in totale
numero di posti prenotati

Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore, 
tranne posti prenotati che va inizializzato a 0.
Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. 
In caso contrario il programma deve lanciare una eccezione.
Aggiungere metodi getter e setter in modo che:
titolo sia in lettura e in scrittura
data sia in lettura e in scrittura
numero di posti totale sia solo in lettura
numero di posti prenotati sia solo in lettura

Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti disponibili deve 
restituire un’eccezione.
disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni restituisce 
un’eccezione.
l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo
Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Evento {
    
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    // Costruttore
    public Evento(String titolo, LocalDate data, int postiTotali) throws Eccezione {
        // Controllo data non passata
        if (data.isBefore(LocalDate.now())) {
            throw new Eccezione("La data non può essere nel passato.");
        }
        
        // Controllo posti totali positivi
        if (postiTotali <= 0) {
            throw new Eccezione("Il numero di posti totali deve essere positivo.");
        }
        
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    // Getter e Setter
    // Titolo: lettura e scrittura
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    // Data: lettura e scrittura
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws Eccezione {
        if (data == null) {
            throw new Eccezione("Inserisci una data valida");
        }
        if (data.isBefore(LocalDate.now())) {
            throw new Eccezione("La data non può essere nel passato");
        }
        this.data = data;
    }

    // Posti totali: solo lettura
    public int getPostiTotali() {
        return postiTotali;
    }

    // Posti prenotati: solo lettura
    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    // Metodo per prenotare un posto
    public void prenota() throws Eccezione{
        // Controllo se l'evento è già passato
        if (data.isBefore(LocalDate.now())) {
            throw new Eccezione("Non è possibile prenotare un evento già passato.");
        }
        
        // Controllo se ci sono posti disponibili
        if (postiPrenotati >= postiTotali) {
            throw new Eccezione("Non ci sono posti disponibili.");
        }
        
        postiPrenotati++;
    }

    // Metodo per disdire una prenotazione
    public void disdici() throws Eccezione{
        // Controllo se l'evento è già passato
        if (data.isBefore(LocalDate.now())) {
            throw new Eccezione("Non è possibile disdire un evento già passato.");
        }
        
        // Controllo se ci sono prenotazioni da disdire
        if (postiPrenotati <= 0) {
            throw new Eccezione("Non ci sono prenotazioni da disdire.");
        }
        
        postiPrenotati--;
    }

    // Override del metodo toString per formattare l'evento
    @Override
    public String toString() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - " + titolo;
    }
}
