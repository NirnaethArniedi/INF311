import tc.TC;

public class Candidat {

	public final String nom;
	public final String prenom;
	public final int note;
	
	public Candidat(String ligne) { 
		
		String[] mots=TC.motsDeChaine(ligne);
		
		this.nom=mots[0];
		this.prenom=mots[1];
		this.note=Integer.parseInt(mots[2]); 
		
	}
	
	public String toString() { return nom+" "+prenom+" "+note; }
	
	public boolean egal(String nom, String prenom) {
		
		return this.nom.equals(nom)&&this.prenom.equals(prenom);
		
	}
	
}
