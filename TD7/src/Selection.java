import tc.TC;

public class Selection {

	public static ListeCandidats selectionner(String[] tabFichiers,
			String ficDesistements, int seuil) {
		
		//TODO
		
		return null;
	}

	public static void main(String[] args) {
		String[] fichiersRegionaux = new String[] { "candidatsAlsace.txt",
				"candidatsAquitaine.txt", "candidatsAuvergne.txt",
				"candidatsBasse-Normandie.txt", "candidatsBourgogne.txt",
				"candidatsBretagne.txt", "candidatsCentre.txt",
				"candidatsChampagne-Ardenne.txt", "candidatsCorse.txt",
				"candidatsFranche-Comte.txt", "candidatsHaute-Normandie.txt",
				"candidatsIle-de-France.txt", "candidatsLanguedoc-Roussillon.txt",
				"candidatsLimousin.txt", "candidatsLorraine.txt",
				"candidatsMidi-Pyrenees.txt", "candidatsNord-Pas-de-Calais.txt",
				"candidatsNord-Pays-de-Loire.txt", "candidatsPicardie.txt",
				"candidatsPoitou-Charentes.txt",
				"candidatsProvence-Alpes-Cote-d-Azur.txt", "candidatsRhone-Alpes.txt" };
		String desistements = "desistements.txt";

		ListeCandidats listeNationale = selectionner(fichiersRegionaux,
				desistements, 17);
		TC.println(listeNationale);
	}

}
