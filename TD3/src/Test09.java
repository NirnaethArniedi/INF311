import tc.TC;
public class Test09 {

	public static void main(String[] args) {
		TC.println("-- lecture dans fichier banque-eponge.txt");
		TC.lectureDansFichier("banque-eponge.txt");
		TC.println("-- test lireBanque( )");
		Banque b = Banque.lireBanque( );
		TC.println("-- Banque (via afficher) :");
		b.afficher( );
	}

}
