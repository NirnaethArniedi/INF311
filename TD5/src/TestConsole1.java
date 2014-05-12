import tc.TC;
public class TestConsole1 {
  public static void main(String[] args) {
    TC.lectureDansFichier("entiers.txt");
    TC.ecritureDansNouveauFichier("sorties.txt");
    PGCDRec.traiter();
  }
}