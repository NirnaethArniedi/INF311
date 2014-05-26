import tc.TC;
public class Test3 {
  public static void main(String[] args) {
    TC.lectureDansFichier("inputa.txt");
    TC.ecritureDansNouveauFichier("outputa3.txt");
    Gogol3.traiter();
    TC.lectureDansFichier("inputb.txt");
    TC.ecritureDansNouveauFichier("outputb3.txt");
    Gogol3.traiter();
  }
}
