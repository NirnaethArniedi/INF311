import tc.TC;
public class Test5 {
  public static void main(String[] args) {
    TC.lectureDansFichier("inputa.txt");
    TC.ecritureDansNouveauFichier("outputa5.txt");
    Gogol5.traiter();
    TC.lectureDansFichier("inputb.txt");
    TC.ecritureDansNouveauFichier("outputb5.txt");
    Gogol5.traiter();
  }
}
