
import java.util.HashMap;
import java.util.LinkedList;

import tc.TC;

public class Reseau {

	int taille;
	HashMap<Station, Integer> ids;
	Station[] stations;
	
	public Reseau(String fichier_stations, String fichier_connections){
		
		TC.lectureDansFichier(fichier_stations);
		int nombreLignes = Integer.parseInt(TC.lireLigne());
		int nombreStationsTotal = Integer.parseInt(TC.lireLigne());
		this.stations = new Station[nombreStationsTotal];
		this.taille = nombreStationsTotal;
		int compteur = 0;

		for (int i = 0; i < nombreLignes; i++) {
			String ligne = TC.lireLigne();
			int nombreStations = Integer.parseInt(TC.lireLigne());
			for (int j = 0; j < nombreStations; j++) {
				this.stations[compteur] = new Station(TC.lireLigne(), ligne);
				compteur++;
			}
		}

		TC.lectureDansFichier(fichier_connections);
		for (int i = 0; i < nombreStationsTotal; i++) {
			String nom = TC.lireLigne();
			String ligne = TC.lireLigne();
			int stationCourante = trouverStation(this.stations, nom, ligne);
			if (stationCourante == -1)
				TC.println("Erreur station courante : " + nom + " " + ligne);
			int nombreVoisines = Integer.parseInt(TC.lireLigne());
			for (int j = 0; j < nombreVoisines; j++) {
				String nomVoisine = TC.lireLigne();
				String ligneVoisine = TC.lireLigne();
				int stationVoisine = trouverStation(this.stations, nomVoisine, ligneVoisine);
				if (stationVoisine == -1)
					TC.println("Erreur station voisine  : " + nomVoisine + " "+ ligneVoisine);
				this.stations[stationCourante].ajouterVoisine(this.stations[stationVoisine]);
			}
			TC.lireLigne();
		}
		
		this.ids = new HashMap<Station, Integer>();
		for(int i=0; i<taille; i++)
			this.ids.put(stations[i], i);
		
	}
	
	public Station trouverStation(String nom, String ligne) {
	    for (Station s : this.stations)
	      if (s.nom.equals(nom) && s.ligne.equals(ligne))
	        return s;
	    throw new IllegalArgumentException("la station " + nom + " n'existe pas sur la ligne " + ligne);
	}
	
	public static int trouverStation(Station[] station, String nom, String ligne) {
		for (int i = 0; i < station.length; i++)
			if (station[i].nom.equals(nom) && station[i].ligne.equals(ligne))
				return i;
		return -1;
	}
	
	public LinkedList<Station> listeStationsDontLeNomEst(String nom){
		LinkedList<Station> res=new LinkedList<Station>();
		for(int i=0; i<taille; i++){
			if(stations[i].nom.equals(nom))
				res.add(stations[i]);
		}
		return res;
	}

	public Reseau(Station[] station) {
		this.taille = station.length;
		this.stations = station;
		this.ids = new HashMap<Station, Integer>();
		for(int i=0; i<taille; i++)
			this.ids.put(station[i], i);
	}
	
	public int getId(Station s){
		return ids.get(s);
	}

	public void afficher() {
		for (int i = 0; i < stations.length; i++)
			stations[i].afficher();
	}

	

}
