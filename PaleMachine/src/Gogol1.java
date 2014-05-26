import tc.TC;


public class Gogol1 {

	public static void traiter() {
		String ligne = TC.lireLigne();
		int nbsite = Integer.parseInt(ligne);
		TC.println(nbsite +" pages web :");
		if(nbsite!=0){
			String[] index = new String[nbsite];
			for(int i=0; i<nbsite; i++){
				String site = TC.lireLigne();
				String[] mots = TC.motsDeChaine(site);
				index[i]=mots[0];
				TC.println(index[i]);
				String plop = TC.lireLigne();
			}
		}
	}
}
