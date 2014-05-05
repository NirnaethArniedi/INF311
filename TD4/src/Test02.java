import tc.TC;
public class Test02 {
	public static void main(String[] args) {
		Compte c = new Compte("Julien Barbaud", 1234567, new Argent(500,0));
		Banque b = new Banque("Banque Neuf", 1);
		b.ajouterCompte(c);
		
		TC.println("-- setLimiteGlobale(100.00)");
		b.setLimiteGlobale(new Argent(100,00));
		
		TC.println("-- test retirer(1234567,43.12) : attend 2 billets de 20 euros, 1 piece de 2 euros, 1 piece de 1 euro, 1 piece de 10 centimes, 1 piece de 2 centimes");
		Liquide res = b.retirer(1234567,new Argent(43,12));
		TC.println(res);
		TC.println("-- solde, limite, retrait cumulatif de compte : attend 456.88 100.00 43.12");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);
		
		TC.println("-- test retirer(1234567,80.00) : attend null");
		res = b.retirer(1234567,new Argent(80,00));
		TC.println(res);
		TC.println("-- solde, limite, retrait cumulatif de compte : attend 456.88 100.00 43.12");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);
		

		TC.println("-- test deposer(1234567,Liquide(6798.33))");
		ArgentPhysique l1 = new Liquide(new Argent(6798,33));
		TC.println("-- liquide : " + l1);
		TC.println("-- test deposer(1234567,liquide) : attend true");
		boolean ok = b.deposer(1234567, l1);
		TC.println(ok);
		TC.println("-- solde, limite, retrait cumulatif de compte : attend 7255.21 100.00 43.12");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);

		ArgentPhysique c1 = new Cheque(new Argent(54,31), "X.");
		TC.println("-- cheque : " + c1);
		TC.println("-- test deposer(1234567, cheque) : attend true");
		ok = b.deposer(1234567, c1);
		TC.println(ok);
		TC.println("-- solde, limite, retrait cumulatif de compte : attend 7309.52 100.00 43.12");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);

		TC.println("-- test retirer(0,1.00) : attend null");
		res = b.retirer(0,new Argent(1,00));
		TC.println(res);
		TC.println("-- test deposer(0,liquide) : attend false");
		ok = b.deposer(0,l1);
		TC.println(ok);
		
	
	}

}
