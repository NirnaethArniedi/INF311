import tc.TC;
public class TestPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n=2;
		//Permutation.afficherListePermutations(n);
		Permutation.afficheToutesUneParUne(n);
		TC.println("true");
		
		int[] t= {2,1};
		t=Permutation.nextPermutation(t);
		TC.print(t);
	}
}
