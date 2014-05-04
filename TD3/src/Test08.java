import tc.TC;
public class Test08 {
	public static void main(String[] args) {
		Banque b = new Banque("Credit_du_Tigre",100);
		Compte c1 = new Compte("Charles_de_Coelacanthe", 123112, new Argent(5,00));
		Compte c2 = new Compte("Alice_Dessinges", 321122, new Argent(2156,73));
		Compte c3 = new Compte("Hippolyte_Megatherium", 234112, new Argent(1003,23));
		Compte c4 = new Compte("Proxy_1", 1000000002, new Argent(10000000,00));
		Compte c5 = new Compte("Distributeur_A", 1010101012, new Argent(0,00));
		b.ajouterCompte(c1);
		b.ajouterCompte(c2);
		b.ajouterCompte(c3);
		b.ajouterCompte(c4);
		b.ajouterCompte(c5);
		String nomFichierSortie = "Test08-sortie.txt";
		TC.println("-- test afficher : attend Credit_du_Tigre, 5, comptes de Charles_de_Coelecanthe, Alice_Dessinges, Hippolyte_Megatherium, Proxy_1, Distributeur_A");
		TC.println("-- redirection de sortie vers fichier " + nomFichierSortie);
		TC.ecritureDansNouveauFichier(nomFichierSortie);
		b.afficher( );
	}

}
