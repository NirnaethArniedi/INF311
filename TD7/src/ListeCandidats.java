
public class ListeCandidats {
	
	public MaillonCandidat tete;
	
	public ListeCandidats() {
		this.tete=null;
	}
	
	public void ajouterEnTete(Candidat c){
		this.tete=new MaillonCandidat(c,this.tete);
	}
	
	public boolean estVide() {
		return this.tete==null;
	}
}
