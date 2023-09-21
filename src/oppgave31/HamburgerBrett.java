package oppgave31;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HamburgerBrett {
	private final BlockingQueue<Hamburger> brett;

	public HamburgerBrett(int kapasitet) {
		brett = new ArrayBlockingQueue<>(kapasitet);
	}

	public void leggPaaHamburger(Hamburger hamburger, String kokkNavn) throws InterruptedException {
		brett.put(hamburger);
		System.out.println(kokkNavn + " (kokk) legger på hamburger " + hamburger + ". Brett: " + brett);
	}

	public Hamburger taAvHamburger(String servitorNavn) throws InterruptedException {
		Hamburger hamburger = brett.take();
		System.out.println(servitorNavn + " (servitør) tar av hamburger " + hamburger + ". Brett: " + brett);
		return hamburger;
	}
}
 