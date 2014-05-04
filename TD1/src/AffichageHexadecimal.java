import maclib.GrafPort;

public class AffichageHexadecimal {

  /**
   * Indique si on doit allumer ou non tel ou tel segment pour afficher le
   * chiffre voulu.
   * 
   * @param segment
   *          le segment en question
   * @param chiffre
   *          le chiffre hexadecimal que l'on veut afficher
   * @return true s'il faut allumer ce segment et false sinon
   */
  public static boolean allumeSegment(int segment, int chiffre) {
	  if (chiffre==8){
		  return true;
	  }
	  if (segment==1) {
		  if (chiffre==0 || chiffre==1 || chiffre==2 || chiffre==3 || chiffre==4 || chiffre==7 || chiffre==8 || chiffre==9 || chiffre==10 || chiffre==13) {
			  return true;
		  }
	  }
	  if (segment==0) {
		  if (chiffre!=1 && chiffre!=4 && chiffre!=11 && chiffre!= 13) {
			  return true;
		  }
	  }
	  if (segment==2) {
		  if (chiffre!=2 && chiffre!=12 && chiffre!=14 && chiffre!=15) {
			  return true;
		  }
	  }
	  if (segment==3) {
		  if (chiffre!=1 && chiffre!=4 && chiffre!=7 && chiffre!=10 && chiffre!=15)
			  return true;
	  }
	  if (segment==4) {
		  if (chiffre!=3 && chiffre!=1 && chiffre!=5 && chiffre!=7 && chiffre!=9 && chiffre!=4) {
			  return true;
		  }
	  }
	  if (segment==5){
		  if (chiffre!=1 && chiffre!=2 && chiffre!=3 && chiffre!=7 && chiffre!=13) {
			  return true;
		  }
	  }
	  if (segment==6) { 
		  if (chiffre!=0 && chiffre!=1 && chiffre!=7 && chiffre!=12) {
			  return true;
		  }
	  }
	  return false; // MODIFIER pour la valeur de retour correcte
  }

  /**
   * Affiche un chiffre hexadecimal dans un afficheur, NE PAS MODIFIER.
   * 
   * @param chiffre
   *          le chiffre que l'on veut afficher
   * @param g
   *          le GrafPort dans lequel on dessine l'afficheur
   */
  public static void afficher(int chiffre, GrafPort g) {
    for (int segment = 0; segment < Afficheur7Segments.NOMBRE_SEGMENTS; ++segment)
      if (allumeSegment(segment, chiffre))
        Afficheur7Segments.allumerSegment(segment, g);
      else
        Afficheur7Segments.eteindreSegment(segment, g);
  }

  // NE PAS MODIFIER
  public static void main(String[] args) {
    // on construit 16 afficheurs, un pour chaque chiffre hexadecimal.
    for (int chiffre = 0; chiffre < 16; ++chiffre)
      afficher(chiffre, Afficheur7Segments.construireAfficheur());
  }

}
