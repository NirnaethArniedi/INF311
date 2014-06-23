import java.util.LinkedList;
import tc.TC;

public class Station {

	String nom;
	String ligne;
	LinkedList<Station> voisines;

	public Station(String nom, String ligne) {
		this.nom = nom;
		this.ligne = ligne;
		this.voisines = new LinkedList<Station>();
	}

	public String toString() {
		String sortie="["+this.nom+", "+this.ligne+"]";
		return sortie;
	}

	public void afficher() {
		TC.println("Station : "+this.nom);
		TC.println("Ligne : "+this.ligne);
		String liste="Stations voisines :";
		for(Station s : this.voisines){
			liste=liste+" "+s.toString();
		}
		TC.println(liste);
		return;
	}

	public void ajouterVoisine(Station s) {
		voisines.add(s);
	}

	public boolean estEgaleA(Station s) {
		return aMemeNomQue(s) && aMemeLigneQue(s);
	}

	public boolean aMemeNomQue(Station s) {
		return this.nom.equals(s.nom);
	}

	public boolean aMemeLigneQue(Station s) {
		return this.ligne.equals(s.ligne);
	}

}
