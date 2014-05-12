import tc.TC;

public class Permutation {
	
	public static void afficher(int[] t){
		for(int i=0;i<t.length-1;++i){
			TC.print(t[i]+" ");
		}
		TC.println(t[t.length-1]);
	}
	
	public static void afficherListePermutations(int n){
		int[][] t=listePermutations(n);
		for(int i=0;i<t.length;++i){
			afficher(t[i]);
		}
	}
	
	public static void afficheToutesUneParUne(int n){
		int[] t=new int[n];
		for(int i=0;i<n;++i) t[i]=n-i;
		while(t!=null){
			afficher(t);
			t=nextPermutation(t);
		}
	}
	
	public static int[] inserer(int[] t, int i){
		//A MODIFIER
		return null;
	}
	
	public static int[][] listePermutations(int n){
		//A MODIFIER
		return null;
	}
	
	public static int[] nextPermutation(int[] t){
		//A MODIFIER
		return null;
	}
}
