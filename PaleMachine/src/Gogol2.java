import tc.TC;


public class Gogol2 {
	public static void traiter() {
		String ligne = TC.lireLigne();
		int nbsite = Integer.parseInt(ligne);
		TC.println(nbsite +" pages web :");
		int mots=0;
		int liens = 0;
		if(nbsite!=0){
			
			String[][] index = new String[nbsite][];
			for(int i=0; i<nbsite; i++){
				String site = TC.lireLigne();
				String[] motsite = TC.motsDeChaine(site);
				index[i]=motsite;
				TC.println(index[i][0]);
				String plop = TC.lireLigne();
			}
			for(int i = 0; i<nbsite; i++){
				String tete = TC.lireLigne();
				String[] ref = TC.motsDeChaine(tete);
				int nbref = Integer.parseInt(ref[1]);
				for(int k = 0; k<nbref; k++){
					String[] reference = TC.motsDeChaine(TC.lireLigne());
					if(reference[0].equals("MOT"))
						mots+=1;
					else if(reference[0].equals("LIEN"))
						liens+=1;
				}
			}
			
		}
		TC.println(mots + " mots et " + liens + " liens");
	}
}
