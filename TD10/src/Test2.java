import tc.TC;

public class Test2 {

	public static void main(String[] args) {
		Reseau r = new Reseau("Stations.txt", "Connections.txt");
		Station origine = r.trouverStation("Place d'Italie", "7");
		Station destination = r.trouverStation("Opéra", "3");

		Tampon tamp = new PileStations();
		RequeteSimple req = new RequeteSimple(r, origine, destination, tamp);
		if (req.reseau != r)
			TC.println("Mauvaise initialisation du champ reseau dans la classe RequeteSimple");
		if (req.predecesseurs == null)
			TC.println("Mauvaise initialisation du tableau de predecesseurs dans la classe RequeteSimple");
		if (req.predecesseurs.length != r.taille)
			TC.println("Mauvaise initialisation de la taille du tableau de predecesseurs dans la classe RequeteSimple");
		if (req.tampon == null)
			TC.println("Mauvaise initialisation du champ tampon dans la classe RequeteSimple");
		if (req.chemin == null || !req.chemin.isEmpty())
			TC.println("Mauvaise initialisation de chemin dans la classe RequeteSimple");
		TC.println("Origine :");
		req.origine.afficher();
		TC.println("Destination :");
		req.destination.afficher();

	}

}
