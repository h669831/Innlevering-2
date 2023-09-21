package oppgave31;

public class Servitor extends Thread {
	 private final HamburgerBrett brett;
	    private final String navn;

	    public Servitor(HamburgerBrett brett, String navn) {
	        this.brett = brett;
	        this.navn = navn;
	    }

	    @Override
	    public void run() {
	        try {
	            while (true) {
	                Hamburger hamburger = brett.taAvHamburger(navn);
	                Thread.sleep(2000 + (int) (Math.random() * 4000)); // Simulerer tid for å bestille en hamburger
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}
