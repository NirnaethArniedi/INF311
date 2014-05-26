import tc.TC;


public class Gogol4 {
	private static int trouverPage(String url, PageWeb[] index ){
		int ref =-1;
		for(int i = 0; i<index.length; i++){
			if(url.equals(index[i].getUrl())){
				ref = i;
			}
		}
		return ref;
	}
	public static void traiter() {
		String ligne = TC.lireLigne();
		int nbsite = Integer.parseInt(ligne);
		if(nbsite!=0){
			PageWeb[] index = new PageWeb[nbsite];
			for(int i = 0; i<nbsite; i++){
				String[] site1 = TC.motsDeChaine(TC.lireLigne());
				String titre = TC.lireLigne();
				int visite = Integer.parseInt(site1[1]);
				index[i] =new PageWeb(site1[0], titre, visite);
			}
			for(int i = 0; i<nbsite; i++){
				String[] ref = TC.motsDeChaine(TC.lireLigne());
				int page=trouverPage(ref[0], index);
				int nbref = Integer.parseInt(ref[1]);
				for(int k = 0; k<nbref; k++){
					String[] entree = TC.motsDeChaine(TC.lireLigne());
					if(entree[0].equals("MOT"))
						index[page].ajouteMot(entree[1]);
					else if(entree[0].equals("LIEN"))
						index[page].ajouteLien(index[trouverPage(entree[1],index)]);
				}
			}
			PageRank.calculeEtRemplit(index);
			int nbrequete = Integer.parseInt(TC.lireLigne());
			for(int k=0; k<nbrequete; k++){
				String requete = TC.lireLigne();
				PageRank.testScores(index, requete);
			}
		}
	}
}
