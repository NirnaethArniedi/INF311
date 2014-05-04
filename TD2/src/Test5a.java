public class Test5a {
  public static void main(String[] args){
    int[] t={1,2};
    Tournoi.afficheTour(t);
    int[] t1=Tournoi.tourPrecedent(t);
    Tournoi.afficheTour(t1);
    int[] t2=Tournoi.tourPrecedent(t1);
    Tournoi.afficheTour(t2);
    int[] t3=Tournoi.tourPrecedent(t2);
    Tournoi.afficheTour(t3);
  }
}