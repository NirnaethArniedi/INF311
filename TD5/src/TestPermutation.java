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
		
		int[] t= new int[2];
		TC.println(t[0]+" "+t[1]);
		t=Permutation.nextPermutation(t);
		TC.println(t[0]+" "+t[1]);
	}
}
