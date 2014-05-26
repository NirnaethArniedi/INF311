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
	public void ajouterEnTete(Candidat c){
		this.tete=new MaillonCandidat(c,this.tete);
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
}
