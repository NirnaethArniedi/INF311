import tc.TC;

public class TestEx9a {

	public static void main(String[] args) {
		
		ListeCandidats liste = new ListeCandidats();
		liste.ajouterEnTete(new Candidat("ZAPPA Frank 2"));
		liste.ajouterEnTete(new Candidat("CLAPTON Eric 13"));
		if (!liste.estVide()) TC.println(liste);

		liste.insererPourTrier(new Candidat("TITTILION Johanna 9"));
		liste.insererPourTrier(new Candidat("THOULIER Sarah 6"));
	    TC.println(liste);
		
	}

}
