public class Test5 {

	public static void main(String[] args) {
		Reseau r = new Reseau("Stations.txt", "Connections.txt");
		Tampon tamp = new FileStations();
		RequeteRealiste req = new RequeteRealiste(r, "Place d'Italie", "Opéra", tamp);
		req.explorer();
		req.construireChemin();
		req.afficherChemin();

	}

}
