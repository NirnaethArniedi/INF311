import tc.TC;
public class Test03 {
	public static void main(String[] args) {
		TC.lectureDansFichier("banque-tigre.txt");
		Banque b = Banque.lireBanque( );
		Argent mille = new Argent(1000,00);
		// 123112 5.00 Charles_de_Coelacanthe
		long n1 = 123112;
		Argent a1 = b.soldeDeCompte(n1);
		// 321122 2156.73 Alice_Dessinges
		long n2 = 321122;
		Argent a2 = b.soldeDeCompte(n2);
		
		TC.println("-- solde de compte #" + n1 + " avant virement : " + a1);
		TC.println("-- solde de compte #" + n2 + " avant virement : " + a2);
		
		TC.println("-- test virer(0, " + n1 + ", " + mille + ") == Banque.EMETTEUR_INCONNU : attend true");
		char res = b.virer(0, n1, mille);
		TC.println(res == Banque.EMETTEUR_INCONNU);
		TC.println("-- solde de compte #" + n1 + " apres virement : attend " + a1);
		TC.println(b.soldeDeCompte(n1));
		
		TC.println("-- test virer(" + n1 + ", 0, " + mille + ") == Banque.DESTINATAIRE_INCONNU : attend true");
		res = b.virer(n1, 0, mille);
		TC.println(res == Banque.DESTINATAIRE_INCONNU);
		TC.println("-- solde de compte #" + n1 + " apres virement : attend " + a1);
		TC.println(b.soldeDeCompte(n1));
		
		TC.println("-- test virer(" + n1 + ", " + n2 + ", " + mille + ") == Banque.SOLDE_INSUFFISANT : attend true");
		res = b.virer(n1, n2, mille);
		TC.println(res == Banque.SOLDE_INSUFFISANT);
		TC.println("-- solde de compte #" + n1 + " apres virement : attend " + a1);
		TC.println(b.soldeDeCompte(n1));
		TC.println("-- solde de compte #" + n2 + " apres virement : attend " + a2);
		TC.println(b.soldeDeCompte(n2));
		
		TC.println("-- test virer(" + n2 + ", " + n1 + ", " + mille + ") == Banque.APPROUVE : attend true");
		res = b.virer(n2, n1, mille);
		TC.println(res == Banque.APPROUVE);
		TC.println("-- solde de compte #" + n1 + " apres virement : attend " + a1.plus(mille));
		TC.println(b.soldeDeCompte(n1));
		TC.println("-- solde de compte #" + n2 + " apres virement : attend " + a2.moins(mille));
		TC.println(b.soldeDeCompte(n2));
		
		TC.println("-- mettre limite de compte #" + n1 + " à 500.00");
		b.setLimite(n1, new Argent(500,00));
		TC.println("-- test virer(" + n1 + ", " + n2 + ", 750.00) == BANQUE.LIMITE_ATTEINTE: attend true");
		res = b.virer(n1, n2, new Argent(750,00));
		TC.println(res == Banque.LIMITE_ATTEINTE);
		
	}
}
