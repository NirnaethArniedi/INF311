
public class MaillonCandidat {
	public final Candidat contenu;
	public MaillonCandidat suivant;
	
	public MaillonCandidat(Candidat c, MaillonCandidat m){
		this.contenu=c;
		this.suivant=m;
	}
	
	public String toString() {
		return this.contenu + " -> " + this.suivant;
	}
	
	public int nombreDeMaillons(){
		if(this.suivant==null){
			return 1;
		}
		return 1 + this.suivant.nombreDeMaillons();
	}
}
