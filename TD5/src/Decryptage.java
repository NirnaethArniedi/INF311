import tc.TC;


public class Decryptage {
	public static void decode(String msg, int[] perm){
		int[] invperm=new int[perm.length];
		for(int i=0;i<perm.length;++i) invperm[perm[i]-1]=i+1;
		int l=msg.length();
		int n=perm.length;
		int k=l/n;
		char[][] mat=new char[l/n][n];
		int pos=0;
		for(int j=0;j<n;j++)
		for(int i=0;i<k;i++)
				mat[i][invperm[j]-1]=msg.charAt(pos++);	
		String res="";
		for (int i = 0; i < k; i++) 
		for (int j = 0; j < n; j++)		
				res += mat[i][j];
		TC.print("Permutation: ");
		Permutation.afficher(perm);
		TC.println("message decode : "+res);
		TC.println();
	}
	
	public static void decodeToutes(String msg, int n){
		//A MODIFIER
		return;
	}

	public static void decodeToutesUneParUne(String msg, int n){
		//A MODIFIER
		return;
	}
}
