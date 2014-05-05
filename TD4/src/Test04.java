import tc.TC;
public class Test04 {
	public static void main(String[] args) {
		TC.lectureDansFichier("banque-tigre.txt");
		Banque b = Banque.lireBanque( );
		
		long nHippo = 234112;
		long nDistrib = 1010101012;

		Argent aHippo = b.soldeDeCompte(nHippo);
		Argent aDistrib = b.soldeDeCompte(nDistrib);

		TC.println("-- solde des comptes #" + nHippo + " (client) et #" 
					+ nDistrib + " (distributeur) : " + aHippo + " " + aDistrib);
		
		String adresse = "1 rue Honore d'Estienne d'Orves";
		Liquide dix = new Liquide(new Argent(10,00));
		Liquide vingt = new Liquide(new Argent(20,00));
		Liquide billets = (dix.fois(100)).plus(vingt.fois(100));
		
		Distributeur d = new Distributeur(b, adresse, nDistrib, billets);
		
		TC.println("-- new Distributeur : ");
		TC.println(d);
		
		TC.println("-- test retirer(0, 50.00) : attend compte inconnu, pas de liquide");
		Retrait res = d.retirer(0,new Argent(50,00));
		TC.println(res);
		
		TC.println("-- test retirer(" + nHippo + ", 990.00) : attend 49x 20 euros, 1x 10 euros");
		res = d.retirer(nHippo,new Argent(990,00));
		TC.println(res);
		
		TC.println("-- solde des comptes #" + nHippo + " (client) et #" + nDistrib 
				+ " (distributeur) : attend 13.23 990.00");
		TC.println(b.soldeDeCompte(nHippo) + " " + b.soldeDeCompte(nDistrib));
		TC.println("-- distributeur : ");
		TC.println(d);
		
		aHippo = b.soldeDeCompte(nHippo);
		aDistrib = b.soldeDeCompte(nDistrib);
		TC.println("-- test retirer(" + nHippo + ", 20.00) : attend insuffisant, pas de liquide");
		res = d.retirer(nHippo,new Argent(20,00));
		TC.println(res);
		
		TC.println("-- solde des comptes #" + nHippo + " (client) et #" + nDistrib 
				+ " (distributeur) : attend 13.23 990.00");
		TC.println(b.soldeDeCompte(nHippo) + " " + b.soldeDeCompte(nDistrib));
		TC.println("-- distributeur : ");
		TC.println(d);
		
		TC.println("-- limiter retrait de compte #" + nHippo + " à 1000.00");
		b.setLimite(nHippo, new Argent(1000,00));
		TC.println("-- deposer cheque de 100.00 sur compte #" + nHippo);
		b.deposer(nHippo, new Cheque(new Argent(100,00),"J. Barbaud"));
		TC.println("-- test retirer(" + nHippo + ", 20.00) : attend depassage de limite, pas de liquide");
		res = d.retirer(nHippo, new Argent(20,00));
		TC.println(res);
		TC.println("-- solde des comptes #" + nHippo + " (client) et #" + nDistrib 
				+ " (distributeur) : attend 113.23 990.00");
		TC.println(b.soldeDeCompte(nHippo) + " " + b.soldeDeCompte(nDistrib));
		TC.println("-- distributeur : ");
		TC.println(d);
		
	}

}
