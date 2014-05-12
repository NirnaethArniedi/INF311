import tc.TC;

public class TestSyntaxe {

  public static void main(String[] args) {
    TC.lectureDansFichier("erreurs_syntaxiques.txt");
    int i = 1;
    while (!TC.finEntree()) {
      try {
        Arithmetique.eval();
        // assertion :
        // on ne doit jamais arriver ici car eval() lance une RuntimeException
        throw new AssertionError(
            "erreur, il fallait lancer une exception pour l'expression " + i);
      } catch (RuntimeException e) {
        // dans ce test, il est normal de recevoir une exception
        TC.println("une faute de syntaxe a bien ete detectee dans l'expression " + i
            + ", " + e.getMessage());
      }
      TC.lireLigne();
      i++;
    }

  }
}
