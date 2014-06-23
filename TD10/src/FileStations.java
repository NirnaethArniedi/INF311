
import java.util.LinkedList;

public class FileStations implements Tampon {
	private LinkedList<Station> liste;

	public FileStations() {
		this.liste = new LinkedList<Station>();
	}

	public void ajouter(Station s) {
		liste.addFirst(s);
	}

	public Station retirer() {
		if (estVide()) return null;
		return liste.removeLast();
	}

	public boolean estVide() {
		return liste.isEmpty();
	}
}