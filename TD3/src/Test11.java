import tc.TC;
public class Test11 {
	public static void main(String[] args) {
		Argent a = new Argent(1234,56);
		Banque b = new Banque("Banque_de_Fou",1);
		long nCharles = 987654321;
		Compte c = new Compte("Charles_Ragondin", 987654321, a);
		TC.println("-- new Compte :");
		TC.println(c);
		b.ajouterCompte(c);

		Argent unEuro = new Argent(1,0);
		Argent million = new Argent(1000000,0);
		
		TC.println("-- test deposer (legal) : attend true");
		boolean ok = b.deposer(nCharles,unEuro);
		TC.println(ok);
		TC.println("-- nouveau solde (via soldeDeCompte) : attend " + a.plus(unEuro));
		TC.println(b.soldeDeCompte(nCharles));
		
		TC.println("-- test retirer (legal) : attend true");
		ok = b.retirer(nCharles,unEuro);
		TC.println(ok);
		TC.println("-- nouveau solde (via soldeDeCompte) : attend " + a);
		TC.println(b.soldeDeCompte(nCharles));
		
		TC.println("-- test deposer (numero pas dans Banque) : attend false");
		ok = b.deposer(0,unEuro);
		TC.println(ok);
		TC.println("-- test retirer (numero pas dans Banque) : attend false");
		ok = b.retirer(0,unEuro);
		TC.println(ok);
		
		TC.println("-- test retirer (montant trop grand) : attend false");
		ok = b.retirer(nCharles,million);
		TC.println(ok);
		TC.println("-- solde (via soldeDeCompte) : attend " + a + " (pas de changement apres retrait illegal)");
		TC.println(b.soldeDeCompte(nCharles));
	}

}
