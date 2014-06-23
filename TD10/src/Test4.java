public class Test4 {

	public static void main(String[] args) {
		Reseau r = new Reseau("Stations.txt", "Connections.txt");
		Station origine = r.trouverStation("Place d'Italie", "5");
		Station destination = r.trouverStation("Opéra", "3");
		Tampon tamp = new PileStations();
		// Tampon tamp = new FileStations();
		RequeteSimple req = new RequeteSimple(r, origine, destination, tamp);
		req.explorer();
		req.construireChemin();
		req.afficherChemin();
	}

}
