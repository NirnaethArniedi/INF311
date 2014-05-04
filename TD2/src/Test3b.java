public class Test3b {
  public static void main(String[] args){
    int[] tab=Tournoi.tableauOrdonne(100);
    System.out.println(Tournoi.estUnePermutation(tab));
    
    Tournoi.melangeTableau(tab);
    System.out.println(Tournoi.estUnePermutation(tab));
    
    tab[5]=0;
    System.out.println(Tournoi.estUnePermutation(tab));
    tab=Tournoi.tableauOrdonne(10000);
    System.out.println(Tournoi.estUnePermutation(tab));
    tab[9999]=1234;
    System.out.println(Tournoi.estUnePermutation(tab));
    tab=Tournoi.tableauOrdonne(1000000);
    System.out.println(Tournoi.estUnePermutation(tab));
    Tournoi.melangeTableau(tab);
    System.out.println(Tournoi.estUnePermutation(tab));
    tab[0]=1000000;
    System.out.println(Tournoi.estUnePermutation(tab));
    tab = new int[] {1,2,3};
    System.out.println(Tournoi.estUnePermutation(tab));
  }
}