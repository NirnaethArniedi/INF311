import tc.TC;


public class Gogol5 {
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
				int num1 = -1, num2 = -1 ;
				int point=0,point2=0;
				for(int i = 0; i<index.length;i++){
					if(index[i].score(requete)>point){
						num2=num1;
						num1=i;
						point2=point;
						point=index[i].score(requete);
					}
					else if(index[i].score(requete)>point2){
						num2=i;
						point2=index[i].score(requete);
					}
				}
				TC.println("MOT="+requete);
				if(num1 == -1){
					TC.println("Aucun resultat");
				}
				else if(num2 ==-1){
					TC.println("URL=" + index[num1].getUrl() + " SCORE=" + point);
				}
				else{
					TC.println("URL=" + index[num1].getUrl() + " SCORE=" + point);
					TC.println("URL=" + index[num2].getUrl() + " SCORE=" + point2);
				}
			}
		}
	}
}
