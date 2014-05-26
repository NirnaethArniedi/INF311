import tc.TC;


public class ListeCandidats {
	
	public MaillonCandidat tete;
	
	public ListeCandidats() {
		this.tete=null;

	}
	
	public ListeCandidats(String nomFichier){
		this.tete=null;
		TC.lectureDansFichier(nomFichier);
		String nomRegion=TC.lireLigne();
		TC.println("creation de la liste des candidats en "+nomRegion);
		
		while (!TC.finEntree()) {
			
			String ligne=TC.lireLigne();
			Candidat c=new Candidat(ligne);
			this.ajouterEnTete(c);	
		}
	}
	
	public boolean estVide() {
		return this.tete==null;
	}
	
	public int longueur() {
		if(estVide())
			return 0;
		return this.tete.nombreDeMaillons();
	}
	
	public String toString(){
		return "liste de " + this.longueur() + " candidat(s) : "+ this.tete;
	}
	
	public void ajouterEnTete(Candidat c){
		if(this.tete==null){
			this.tete=new MaillonCandidat(c,this.tete);
		}
		else{
			this.tete=new MaillonCandidat(c,this.tete);
		}
	}
	
	public boolean retirer(String nom, String prenom){
		if(this.estVide())
			return false;
		if(this.tete.contenu.egal(nom, prenom)){
			this.tete=this.tete.suivant;
			return true;
		}
		MaillonCandidat curseur = this.tete;
		while(curseur.suivant!=null&&!curseur.suivant.contenu.egal(nom,prenom)){
			curseur=curseur.suivant;
		}
		if(curseur.suivant==null)
			return false;
		else{
			curseur.suivant=curseur.suivant.suivant;
			return true;
		}
	}
	

	public void filtrerAdmissibles(int seuil){
		MaillonCandidat curseur=this.tete;
		while(curseur!=null){
			if(curseur.contenu.note<seuil)
				this.retirer(curseur.contenu.nom, curseur.contenu.prenom);
			curseur=curseur.suivant;
		}
		// Beware, une fois qu'on a filtr'e, les maillons sous le seuil sont perdus pour l'utilisateur parce au'ils ne sont plus relies a rien.
		
	}
	
	public void concatener(ListeCandidats liste){
		if(this.estVide()){
			this.tete=liste.tete;
		}
		else{
			MaillonCandidat curseur =this.tete;
			while(curseur.suivant!=null){
				curseur=curseur.suivant;
			}
			curseur.suivant=liste.tete;
		}
	}
}
