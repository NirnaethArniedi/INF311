import tc.TC;

public class TestEx3b {

	public static void main(String[] args) {
		
		ListeCandidats liste = new ListeCandidats();
		if (liste.estVide()) TC.println(liste);
		liste.ajouterEnTete(new Candidat("FONFEC Sophie 13"));
		if (!liste.estVide()) TC.println(liste);		
		liste.ajouterEnTete(new Candidat("HADY Jacques 7"));
		if (!liste.estVide()) TC.println(liste);
		
	}

}
