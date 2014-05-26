import tc.TC;

public class TestEx2 {

	public static void main(String[] args) {
		
		ListeCandidats liste = new ListeCandidats();
		if (liste.estVide()) 
                    TC.println("Liste A (vide: " + liste.estVide()+")  : " + liste.tete);
		liste.ajouterEnTete(new Candidat("FONFEC Sophie 13"));
		if (!liste.estVide()) 
                    TC.println("Liste B (vide: " + liste.estVide()+") : " + liste.tete);
		liste.ajouterEnTete(new Candidat("HADY Jacques 7"));
		if (!liste.estVide()) 
                    TC.println("Liste C (vide: " + liste.estVide() + ") : " + liste.tete);
		
	}

}
