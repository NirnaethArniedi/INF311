public class Test6 {

	public static void main(String[] args) {
		Reseau r = new Reseau("Stations.txt", "Connections.txt");
		Tampon tamp = new FileStations();
		RequeteParesseuse req = new RequeteParesseuse(r, "Place d'Italie", "Opéra", tamp);
		req.explorer();
		req.construireChemin();
		req.afficherChemin();
	}

}
