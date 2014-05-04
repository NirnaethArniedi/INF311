import tc.TC;
public class Test05 {
	public static void main(String[] args) {
		Banque b = new Banque("Credit_du_Tigre",100);
		Compte c1 = new Compte("Julien_Barbaud",1001,new Argent(15,00));
		Compte c2 = new Compte("Alice_Truite",1002,new Argent(64,13));
		TC.println("-- comptes:");
		TC.println(c1);
		TC.println(c2);
		
		TC.println("-- test ajouterCompte : attend true, true");
		boolean ok = b.ajouterCompte(c1);
		TC.println(ok);
		ok = b.ajouterCompte(c2);
		TC.println(ok);
		
		TC.println("-- test aCompte(1001), aCompte(1002) : attend true, true");
		ok = b.aCompte(1001L);
		TC.println(ok);
		ok = b.aCompte(1002L);
		TC.println(ok);
		
		TC.println("-- test ajouterCompte (numéro 1001 déjà utilisé) : attend false");
		Compte c3 = new Compte("Mathilde_Meduse", 1001, new Argent(123,45));
		ok = b.ajouterCompte(c3);
		TC.println(ok);

		TC.println("-- test soldeDeCompte(1002) : attend 64.13");
		Argent a = b.soldeDeCompte(1002L);
		TC.println(a);

		TC.println("-- test soldeDeCompte(999999) : attend null");
		a = b.soldeDeCompte(999999);
		TC.println(a);
		
		TC.println("-- test ajouterCompte au-delà de max comptes");
		Argent zero = new Argent(0,0);
		for(int i = 2; i < 100; i++) { // remplir la banque
			if( ! b.ajouterCompte(new Compte("Test",2000+i,zero)) ) {
				TC.println("ERREUR banque pleine trop tôt (" + (i+1) + "-ième ajouterCompte)");
				return;
			}
		}
		if( b.ajouterCompte(new Compte("Trop",3000,zero)) ) // ajouter une compte de trop
			TC.println("ERREUR banque devrait être pleine");
		else
			TC.println("OK");
	}

}
