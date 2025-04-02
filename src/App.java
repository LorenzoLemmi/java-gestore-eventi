/*Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i 
parametri.
Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare 
ad effettuarle, implementando opportuni controlli
Stampare a video il numero di posti prenotati e quelli disponibili
Chiedere all’utente se e quanti posti vuole disdire
Provare ad effettuare le disdette, implementando opportuni controlli
Stampare a video il numero di posti prenotati e quelli disponibili
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Chiedi all'utente i dettagli dell'evento
            System.out.println("Inserisci i dettagli dell'evento:");
            
            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();
            
            System.out.print("Data (formato dd/MM/yyyy): ");
            String dataString = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            
            System.out.print("Posti totali: ");
            int postiTotali = scanner.nextInt();
            scanner.nextLine(); 
            
            // Crea l'evento
            Evento evento = new Evento(titolo, data, postiTotali);
            
            // Prenotazione
            System.out.print("Quanti posti vuoi prenotare? ");
            int postiDaPrenotare = scanner.nextInt();
            scanner.nextLine();
            
            // Effettua prenotazioni
            for (int i = 0; i < postiDaPrenotare; i++) {
                evento.prenota();
            }
            
            // Stampa posti prenotati e disponibili
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
            
            // Disdette
            System.out.print("Quanti posti vuoi disdire? ");
            int postiDaDisdire = scanner.nextInt();
            scanner.nextLine();
            
            // Effettua disdette
            for (int i = 0; i < postiDaDisdire; i++) {
                evento.disdici();
            }
            
            // Stampa posti prenotati e disponibili dopo le disdette
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
            
        } catch (Eccezione e) {
            System.out.println("Errore: " + e.getMessage());
        }
        
        scanner.close();
    }
}