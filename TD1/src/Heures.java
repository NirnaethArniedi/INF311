import tc.TC;

public class Heures {
  /**
   * Renvoie une chaine de la forme "H : M : S", pour un affichage digital.
   * 
   * A COMPLETER. Vous devez expliciter le calcul des valeurs des heures,
   * minutes et secondes.
   * 
   * @param secondes
   *          nombre total de secondes indiquant l'heure que l'on doit convertir
   * @return la chaine Java correspondante (type String)
   */
  public static double heures(int secondes) {
	  return (secondes)/3600;  
  }

  public static double minutes(int secondes) {
	  double s=secondes-heures(secondes)*3600;
	  return (s-(s % 60))/60;
  }
  
  public static double Secondes(int secondes) {
	  double s=secondes - heures(secondes)*3600-minutes(secondes)*60;
	  return s;
  }
  public static String chaineDe(int secondes) {
    return (int) Heures.heures(secondes) + " : " + (int) Heures.minutes(secondes) + " : " + (int) Heures.Secondes(secondes); // ceci utilise la surcharge de +
  }
 
  public static int lireEntier(String invite) {
	  int entree;
	  TC.print(invite);
	  entree = TC.lireInt();
	  return entree;
  }
  public static int lireHMS(String invite) {
	  int He; int Mi; int Se;
	  TC.print(invite);
	  He = TC.lireInt();
	  Mi = TC.lireInt();
	  Se = TC.lireInt();
	  return (He*3600+Mi*60+Se);
  }
  public static void main(String[] args) {
    // test exercice 2
    TC.println(chaineDe(2000));
    TC.println(chaineDe(1));
    TC.println(chaineDe(59));
    TC.println(chaineDe(60));
    TC.println(chaineDe(119));
    TC.println(chaineDe(120));
    TC.println(chaineDe(3599));
    TC.println(chaineDe(3600));
    TC.println(chaineDe(3601));
    TC.println(chaineDe(4000));
    TC.println(chaineDe(24 * 3600 - 1));
    // TEST EXO 4
    String message = "combien de secondes ? ";
    int secondes_1 = lireEntier(message);
    TC.println(chaineDe(secondes_1));
    int secondes_2 = lireEntier(message);
    TC.println(chaineDe(secondes_2));
    TC.print("total = ");
    TC.println(chaineDe(secondes_1+secondes_2));
    int secondes_3= lireHMS("entrer heures minutes secondes : ");
    int secondes_4 = lireHMS("entrer heures minutes secondes : ");
    TC.print("total = ");
    TC.println(chaineDe(secondes_3+secondes_4));
  }
}
