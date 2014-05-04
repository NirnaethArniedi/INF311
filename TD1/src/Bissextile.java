import tc.TC;

public class Bissextile {

	public static boolean estBissextile(int annee) {
		int res;
		if (annee%100==0) {
			res=annee/4;
			if (res%4==0) {
				return true;
			}
			else {
				return false;
			}
		}
		if (annee%4==0) {
			return true;
		}
	
	return false;	
	}
	
	public static void affichage(int annee) {
		if (estBissextile(annee)) {
			TC.println(annee+" est bissextile");
		}
		else {
			TC.println(annee+" n'est pas bissextile");
		}
		
	}
	
	public static void main(String[] args) {
		affichage(1900);
		affichage(1901);
		affichage(1904);
		affichage(2000);
	}
}
