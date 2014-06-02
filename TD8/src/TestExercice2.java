import tc.TC;

public class TestExercice2 {	
    public static void main(String[] args) {
	    Index T1 = new Index("grec");

	    TC.println("Test 2a : ");
	    String[] mots = {"Gamma", "Psi", "Beta", "Phi", "Beta", "Kappa", "Mu", "Delta", "Nu","Gamma","Alpha","Zeta","Lambda"};
	    int[] lignes = {1,1,1,1,2,2,2,2,3,3,3,3,3};
	    for(int i = 0; i < 13; i++) {
	    	TC.print("Tapez enter/retour pour ajouter le "+(i+1)+"-ième mot...");
	    	TC.lireLigne( );
	    	T1.ajouterMot(mots[i], lignes[i]);
	    	T1.dessiner( );
	    }
	    
	    TC.println("Test 2b : ");
		Index T2v = new Index("test-2b");
		TC.println("Indexation de verne.txt...");
		TC.lectureDansFichier("verne.txt");
		T2v.ajouterTexte( );
		TC.println("'colonnes' apparaît aux lignes : " + T2v.lignesDe("colonnes"));
    }    
}
