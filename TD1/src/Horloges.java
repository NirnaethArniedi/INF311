import maclib.GrafPort;


public class Horloges {

  /**
   * Fait le dessin des trois aiguilles.
   * 
   * A COMPLETER. Vous devez ajouter le calcul de la position angulaire de
   * chaque aiguille.
   * 
   * @param g
   *          le GrafPort dans lequel on dessine,
   * @param secondes
   *          nombre total de secondes indiquant l'heure que l'on doit afficher
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
  public static void tracerAiguilles(GrafPort g, int secondes) {
	double se=secondes;
	double min=((minutes(secondes))%60)/60;
    // pour l'aiguille des heures
    DessinHorloge.tracerHeures(g, (se%(12*3600))/(12*3600) );
    // pour l'aiguille des minutes
    DessinHorloge.tracerMinutes(g, min);
    // et pour l'aiguille des secondes
    DessinHorloge.tracerSecondes(g, (Secondes(secondes)/60));
  }

  /**
   * Affiche le dessin d'une horloge, NE PAS MODIFIER. Cette fonction initialise
   * le graphique par DessinHorloge.construireCadran et appelle les fonctions
   * DessinHorloge.affichageDigital et tracerAiguilles.
   * 
   * @param secondes
   *          nombre total de secondes indiquant l'heure que l'on doit afficher
   */
  public static void afficherHorloge(int secondes) {
    // on construit un cadre de dessin
    GrafPort g = DessinHorloge.construireCadran();
    // pour l'affichage digital
    DessinHorloge.affichageDigital(g, secondes);
    // pour tracer les aiguilles
    tracerAiguilles(g, secondes);
  }

  public static void main(String[] args) {
	
    afficherHorloge(2000);
    afficherHorloge(40000);
    afficherHorloge(56000);
  }

}
