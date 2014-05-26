
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
}
