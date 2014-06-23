
import java.util.LinkedList;

public class PileStations implements Tampon {
	private LinkedList<Station> liste;

	public PileStations() {
		this.liste = new LinkedList<Station>();
	}

	public void ajouter(Station s) {
		liste.addFirst(s);
	}

	public Station retirer() {
		if (estVide()) return null;
		return liste.remove();
	}

	public boolean estVide() {
		return liste.isEmpty();
	}
}