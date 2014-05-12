/**
 * @author Luca Castelli Aleardi, Philippe Chassignet (INF311, 2014)
 * 
 *         Programme permettant de resoudre le probleme des 8 reines
 * 
 *         L'etat de l'echiquier est decrit par le tableau int[] echiquier: la
 *         reine d'indice i ( 0<= i < n) est placee a' la position suivante:
 *         ligne d'indice i; colonne d'indice echiquier[i]
 * 
 */
public class HuitReines {

  public static void genereConfigurationsSansConflit(Echiquier echiquier) {
    ajouteNouvelleReine(echiquier, 0); // commence par placer la premiere reine
                                       // (d'indice 0)
    System.out.println(echiquier.nombreDeSolutions()+" solutions");
  }

  /**
   * Cerche de placer la reine d'indice 'n' sur l'echiquier decrit par le
   * tableau 'reines' On place la reine 'n' a' la ligne d'indice 'n', dans
   * toutes les colonnes de 0..N-1
   * 
   * @param echiquier
   *          le tableau donnant la position des reines deja placees
   * @param indice
   *          de la reine a placer (et tester)
   */
  public static void ajouteNouvelleReine(Echiquier echiquier, int indiceReine) {
	// A COMPLETER (exo3)
  }

  public static void main(String[] args) {
    genereConfigurationsSansConflit(new Echiquier(4, true));
    genereConfigurationsSansConflit(new Echiquier(5,false));
    genereConfigurationsSansConflit(new Echiquier(10,false));
    genereConfigurationsSansConflit(new Echiquier(13,false));
  }

}
