import tc.TC;

public class Test1 {

	public static void main(String[] args) {
		Reseau r = new Reseau("Stations.txt", "Connections.txt");
		Station test = r.stations[12];
		TC.ecritureDansNouveauFichier("output_ex1.txt");
		TC.println(test);
		test.afficher();
	}
}
