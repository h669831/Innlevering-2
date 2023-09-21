package oppgave31;

public class Kokk extends Thread {
	private final HamburgerBrett brett;
	private final String navn;

	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(2000 + (int) (Math.random() * 4000)); // Simulerer tid for å lage en hamburger
				Hamburger hamburger = new Hamburger();
				brett.leggPaaHamburger(hamburger, navn);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
