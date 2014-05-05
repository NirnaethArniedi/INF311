import tc.TC;
public class Test01 {
	public static void main(String[] args) {
		Compte c = new Compte("Julien Barbaud", 1234567, new Argent(1190,0));
		Banque b = new Banque("Banque Neuf", 1);
		boolean res = b.ajouterCompte(c);
		assert(res);
		
		TC.println("-- compte avant : " + c);
		TC.println("-- limite de compte : attend null");
		TC.println(c.limite);
		
		TC.println("-- test setLimiteGlobale(100.00)");
		b.setLimiteGlobale(new Argent(100,00));
		TC.println("-- solde, compte, retrait cumulatif de compte : attend 1190.00 100.00 0.00");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);
		
		TC.println("-- test retirer(1234567,50.00) : attend true");
		res = b.retirer(1234567,new Argent(50,00));
		TC.println(res);
		TC.println("-- solde, limite, retrait cumulatif de compte: attend 1140.00 100.00 50.00");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);
		
		TC.println("-- test retirer(1234567,50.00) : attend true");
		res = b.retirer(1234567,new Argent(50,00));
		TC.println(res);
		TC.println("-- solde, limite, retrait cumulatif de compte: attend 1090.00 100.00 100.00");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);
		
		TC.println("-- test retirer(1234567,50.00) : attend false");
		res = b.retirer(1234567,new Argent(50,00));
		TC.println(res);
		TC.println("-- solde, limite, retrait cumulatif de compte: attend 1090.00 100.00 100.00");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);
		
		TC.println("-- test setLimite(1234567,160.00)");
		b.setLimite(1234567, new Argent(160,00));
		TC.println("-- test retirer(1234567,50.00) : attend true");
		res = b.retirer(1234567,new Argent(50,00));
		TC.println(res);
		TC.println("-- solde, limite, retrait cumulatif de compte: attend 1040.00 160.00 150.00");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);
		
		TC.println("-- test setLimite(1234567,null)");
		b.setLimite(1234567,null);
		TC.println("-- test retirer(1234567,1000.00) : attend true");
		res = b.retirer(1234567, new Argent(1000,00));
		TC.println(res);
		TC.println("-- solde, limite, retrait cumulatif de compte: attend 40.00 null 1150.00");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);
		
		TC.println("-- test minuit( )");
		b.minuit( );
		TC.println("-- solde, limite, retrait cumulatif de compte: attend 40.00 null 0.00");
		TC.println(c.solde + " " + c.limite + " " + c.retraitCumulatifAujourdhui);
		
	}

}
