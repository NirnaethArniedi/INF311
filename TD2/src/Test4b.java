public class Test4b {
  public static void main(String[] args){
    int[] tab={8,1,15,10,2,14,5,4,3,7,11,12,13,16,9,6};
    boolean[][] res={{false,true,false,false,true,false,false,false},{false,false,true,false},{true,false},{true}};
    System.out.println(Tournoi.vainqueur(tab,res));
  }
}