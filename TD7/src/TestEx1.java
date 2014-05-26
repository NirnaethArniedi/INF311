import tc.TC;

public class TestEx1 {

	public static void main(String[] args) {
		
		MaillonCandidat m = null;
		
		TC.println("Au debut, m vaut " + m + ".");
		TC.println();

		Candidat c = new Candidat("FONFEC Sophie 13");
		m = new MaillonCandidat(c, null);
		TC.println("Puis, m pointe vers le maillon de " + m.contenu + ",");
		TC.println("mais son suivant est " + m.suivant + ".");
		TC.println();
		
		c = new Candidat("HADY Jacques 7");
		m = new MaillonCandidat(c, m);
		TC.println("Finalement, m reference le maillon de " + m.contenu + ",");
		TC.println("mais egalement, via m.suivant, le maillon de "
				+ m.suivant.contenu + ",");
		TC.println("qui est le dernier maillon car m.suivant.suivant vaut "
				+ m.suivant.suivant + ".");
		TC.println();
		
		//TC.println("Ainsi, m reference la liste : "+m);
		
	}
	
}
