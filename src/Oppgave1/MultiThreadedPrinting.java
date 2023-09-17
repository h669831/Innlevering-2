package Oppgave1;
import javax.swing.*;

public class MultiThreadedPrinting {
	
    public static void main(String[] args) {
    	//String message = "Hallo Verden";
        // Tråd for å la brukeren taste inn meldinger
        Thread inputThread = new Thread(() -> {
            while (true) {
                String message = JOptionPane.showInputDialog("Skriv inn en melding (quit for å avslutte):");
                if (message == null || message.equalsIgnoreCase("quit")) {
                    // Avslutt programmet hvis brukeren skriver "quit" eller lukker dialogboksen
                    System.exit(0);
                } else {
                    // Skriv ut den nye meldingen
                    System.out.println("Bruker skrev: " + message);
                }
                try {
                    // Vent på brukerinndata-tråden for å starte
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Tråd for å skrive ut standardmeldingen
                while (true) {
                    System.out.println(message);
                    try {
                        Thread.sleep(3000); // Vent i 3 sekunder
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
