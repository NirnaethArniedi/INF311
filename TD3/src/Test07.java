import tc.TC;
public class Test07 {
	public static void main(String[] args) {
		long numero = 99887766;
		Argent a = new Argent(5544,33);
		String nom = "Agathe_Oursin";
		String s = "" + numero + " " + a + " " + nom;
		TC.println("-- test constructeur Compte(String) ");
		Compte c = new Compte(s);
		TC.println("-- numero : attend " + numero);
		TC.println(c.numero);
		TC.println("-- nom : attend " + nom);
		TC.println(c.nom);
		TC.println("-- solde : attend " + a);
		TC.println(c.solde);
	}
}
