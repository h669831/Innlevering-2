package oppgave21;

import java.util.Random;

class Servitor extends Thread {
	  private final HamburgerBrett brett;
	    private final String navn;

	    public Servitor(HamburgerBrett brett, String navn) {
	        this.brett = brett;
	        this.navn = navn;
	    }

	    @Override
	    public void run() {
	        Random random = new Random();
	        try {
	            while (true) {
	                Thread.sleep(2000 + random.nextInt(5000)); // Simulerer tid for å bestille en hamburger
	                synchronized (brett) {
	                    Hamburger hamburger = brett.taAvForsteHamburger(navn);
	                    System.out.println(navn + " (servitør) har mottatt hamburger " + hamburger);
	                    brett.notifyAll(); // Vekk eventuelle kokker som venter på å legge til hamburgere.
	                }
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}