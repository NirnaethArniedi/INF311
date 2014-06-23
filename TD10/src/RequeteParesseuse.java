import java.util.LinkedList;
import tc.TC;

public class RequeteParesseuse {
	
	public Reseau reseau;
	public String origine,destination;
	public Tampon tampon;
	public Station[] predecesseurs;
	public LinkedList<Station> chemin;
	
	public RequeteParesseuse(Reseau r, String origine, String destination, Tampon t){
		this.reseau = r;
		this.origine = origine;
		this.destination = destination;
		this.tampon = t;
		this.predecesseurs = new Station[r.taille];
		this.chemin = new LinkedList<Station>();
	}
	
	public void setPredecesseur(Station from, Station to){
		int idTo=reseau.getId(to);
		predecesseurs[idTo]=from;
		return ;
	}
	
	public Station getPredecesseur(Station s){
		int idS = reseau.getId(s);
		return predecesseurs[idS];
	}
	
	public boolean estDejaAtteinte(Station s){
		int idS = reseau.getId(s);
		if(predecesseurs[idS]==null)
			return false;
		return true;
	}
	
	public boolean estDestination(Station s){
		
		if(s.nom.equals(destination))
			return true;
		return false;
	}
	
	public void explorer(){
		LinkedList<Station> listeOrigine=reseau.listeStationsDontLeNomEst(origine);	
		setPredecesseur(listeOrigine.getFirst(),listeOrigine.getFirst());
		tampon.ajouter(listeOrigine.getFirst());
		while(!tampon.estVide()){
			Station del = tampon.retirer();
			for(Station s : del.voisines){
				if(estDestination(s)){
					setPredecesseur(del,s);
					return;
				}
				else if(!estDejaAtteinte(s)){
					setPredecesseur(del,s);
					tampon.ajouter(s);
				}
			}
		}
		return;
	}
	
	public void construireChemin(){
		LinkedList<Station> listeDest=reseau.listeStationsDontLeNomEst(destination);
		for(Station s : listeDest){
			if(estDejaAtteinte(s)){
				int id;
				id=reseau.getId(s);
				Station ori=s;
				chemin.addFirst(ori);
				while(!reseau.stations[id].nom.equals(origine)){
					chemin.addFirst(predecesseurs[id]);
					id = reseau.getId(predecesseurs[id]);
				}
				return ;
			}
		}
	}
	
	public void afficherChemin(){
		for(Station s : chemin){
			TC.println(s.toString());
		}
	}
	
}
