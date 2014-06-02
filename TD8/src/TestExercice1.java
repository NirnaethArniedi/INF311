import tc.TC;

public class TestExercice1 {
	public static void main(String[] args) {
		String[] mots = {"Gamma", "Beta", "Alpha", "Delta", "Psi", "Phi", "Kappa", "Mu", "Lambda", "Nu", "Zeta"};
		int[][] t = {{1,3}, {1,2}, {3}, {2}, {1}, {1}, {2}, {2}, {3}, {3}, {3}};
		
		Noeud[] noeuds = new Noeud[11];
		for(int i = 0; i < 11; i++) {
			Entree e = new Entree(mots[i]);
			for(int j = 0; j < t[i].length; j++)
				e.ajouter(t[i][j]);
			
			noeuds[i] = new Noeud (e);
		}
		
		Index T1 = new Index("test-ex1");
		T1.racine = noeuds[0];
		T1.racine.gauche = noeuds[1];
		noeuds[1].gauche = noeuds[2];
		noeuds[1].droit = noeuds[3];
		T1.racine.droit = noeuds[4];
		noeuds[4].gauche = noeuds[5];
		noeuds[5].gauche = noeuds[6];
		noeuds[6].droit = noeuds[7];
		noeuds[7].gauche = noeuds[8];
		noeuds[7].droit = noeuds[9];
		noeuds[4].droit = noeuds[10];
		
		// Partie a du test pour Ex. 1
		TC.println("Test 1a : ");
		TC.println("'Kappa' apparaît aux lignes : " + T1.lignesDe("Kappa"));

		// Partie b du test pour Ex. 1
		TC.println("Test 1b : ");
		TC.println("'Iota' apparaît aux lignes : " + T1.lignesDe("Iota"));

		// Partie c du test pour Ex. 1
		TC.println("Test 1c : ");
		TC.println("'Beta' apparaît aux lignes : " + T1.lignesDe("Beta"));
	}
}
