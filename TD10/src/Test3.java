import tc.TC;

public class Test3 {

	public static void main(String[] args) {
		Reseau r = new Reseau("Stations.txt", "Connections.txt");
		Station origine = r.trouverStation("Place d'Italie", "7");
		Station destination = r.trouverStation("Opéra", "3");

		Tampon tamp = new PileStations();
		RequeteSimple req1 = new RequeteSimple(r, origine, destination, tamp);
		req1.explorer();
		TC.ecritureDansNouveauFichier("output_ex3_pile.txt");
		for (int s = 0; s < r.taille; s++) {
			TC.print(r.stations[s]);
			TC.print(" : ");
			if (req1.getPredecesseur(r.stations[s]) != null) 
				TC.print(req1.getPredecesseur(r.stations[s]));
			else TC.print("non atteint");
			TC.println();
		}

		Tampon tamp2 = new FileStations();
		RequeteSimple req2 = new RequeteSimple(r, origine, destination, tamp2);
		req2.explorer();
		TC.ecritureDansNouveauFichier("output_ex3_file.txt");
		for (int s = 0; s < r.taille; s++) {
			TC.print(r.stations[s]);
			TC.print(" : ");
			if (req2.getPredecesseur(r.stations[s]) != null) 
				TC.print(req2.getPredecesseur(r.stations[s]));
			else TC.print("non atteint");
			TC.println();
		}

	}

}
