import tc.TC;

public class TestEx3a {

	public static void main(String[] args) {
		
		ListeCandidats liste = new ListeCandidats();
		liste.ajouterEnTete(new Candidat("FONFEC Sophie 13"));
		TC.println("Nombre de maillons de la liste A : " + liste.tete.nombreDeMaillons());		
		liste.ajouterEnTete(new Candidat("HADY Jacques 7"));
		liste.ajouterEnTete(new Candidat("ZAPPA Frank 2"));
		TC.println("Nombre de maillons de la liste B : " + liste.tete.nombreDeMaillons());		
		
	}

}
