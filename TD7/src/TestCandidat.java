import tc.TC;

public class TestCandidat {

	public static void main(String[] args) {
		
		String nomFichier="candidatsPicardie.txt";
		TC.lectureDansFichier(nomFichier);
		
		String nomRegion=TC.lireLigne();
		TC.println("fichier de la region : "+nomRegion);
		
		while (!TC.finEntree()) {
		
			String ligne=TC.lireLigne();
			TC.println("ligne lue : "+ligne);
			
			Candidat c=new Candidat(ligne);
			TC.println("  --> creation du candidat : "+c);
			
		}
		TC.println("fin de fichier atteinte");
	
	}

}
