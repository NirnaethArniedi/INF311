import tc.TC;
public class TestConsole2 {
  public static void main(String[] args) {
    TC.lectureDansFichier("mots.txt");
    TC.ecritureDansNouveauFichier("sorties_mots.txt");
    Palindromes.traiter();
    TC.lectureDansFichier("MotsFrancais.txt");
    TC.ecritureDansNouveauFichier("sorties_MotsFrancais.txt");
    Palindromes.traiter();
  }
}
