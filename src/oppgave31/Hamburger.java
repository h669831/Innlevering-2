package oppgave31;

public class Hamburger {
	 private static int count = 0;
	    private final int id;

	    public Hamburger() {
	        id = ++count;
	    }

	    public int getId() {
	        return id;
	    }

	    @Override
	    public String toString() {
	        return "◖" + id + "◗";
	    }
}
