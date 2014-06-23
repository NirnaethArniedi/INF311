import java.util.LinkedList;
import tc.TC;

public class RequeteSimple {
	public Reseau reseau;
	public Station origine,destination;
	public Tampon tampon;
	public Station[] predecesseurs;
	public LinkedList<Station> chemin;

	public RequeteSimple(Reseau r, Station origine, Station destination, Tampon t){
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
		if(s.estEgaleA(destination))
			return true;
		return false;
	}
	
	public void explorer(){
		setPredecesseur(origine, origine);
		tampon.ajouter(origine);
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
		int id = reseau.getId(destination);
		int idOri = reseau.getId(origine);
		chemin.addFirst(destination);
		while(!(id==idOri)){
		chemin.addFirst(predecesseurs[id]);
		id = reseau.getId(predecesseurs[id]);
		}
		return ;
	}
	
	public void afficherChemin(){
		for(Station s : chemin){
			TC.println(s.toString());
		}
	}
}
