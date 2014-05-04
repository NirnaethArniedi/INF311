import tc.TC;
public class Compte {
	public final String nom;
	public final long numero;
	public Argent solde;
	
	public Compte(String nom, long numero, Argent montant) {
		this.nom = nom;
		this.numero = numero;
		this.solde = montant;
	}
	
	public Compte(String str){
		String[] mots=TC.motsDeChaine(str);
		this.numero=Long.parseLong(mots[0]);
		Argent a=new Argent(mots[1]);
		this.solde=a;
		this.nom=mots[2];
	}
	
	public String toString( ){
		return this.numero+" "+this.solde+" "+this.nom;
	}
	
}
