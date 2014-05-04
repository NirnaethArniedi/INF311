import tc.TC;

public class BoucleBissextile {
	
	public static int lireEntier(String invite) {
		int entier;
		TC.print(invite);
		entier=TC.lireInt();
		return entier;
	}
	
	
	
	public static void main(String[] args) {
		int an=lireEntier("Entrer une valeur : ");
		while (an>=0) {
			Bissextile.affichage(an);
			an=lireEntier("Entrer une valeur : ");
		}
	
		TC.println("Au revoir");
		return;
		
	}
	
}
