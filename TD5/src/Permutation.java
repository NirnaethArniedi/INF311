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
		int n = t.length+1;
		int[] tab = new int[n];
		for(int p = 0 ; p < i ; p++)
			tab[p] = t[p];
		tab[i]=n;
		for(int p = i+1; p < n ; p++)
			tab[p] = t[p-1];
		return tab;
	}
	
	private static int fact(int n){
		if(n==0)
			return 1;
		else
			return n*fact(n-1);
	}
	
	public static int[][] listePermutations(int n){
		if(n==0)
			return null;
		int[][] liPe = new int[fact(n)][n];
		if(n==1){
			liPe[0][0] = 1;
		}
		else{
			int c = 0;
			int[][] listPermMoinUn=listePermutations(n-1);
			for(int i = 0; i < fact(n-1); i++){
				for(int k = 0; k < n ; k++){
					liPe[c]=inserer(listPermMoinUn[i],k);
					c+=1;
				}
			}
		}
		return liPe;
	}
	
	public static int[] nextPermutation(int[] t){
		//A MODIFIER
		return null;
	}
}
