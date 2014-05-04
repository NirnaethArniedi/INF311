import tc.TC;

public class Tournoi {

	
	public static int log2(int n){
		
		int k=0;
		while(n%2==0){
			n/=2;
			k+=1;
		}
		return k;
	}
	
	public static void afficheTour(int[] tab){
		int lon=tab.length;
		for(int i=0; i<lon; i+=2){
			TC.print("("+tab[i]+" vs. "+tab[i+1]+")");
		}
		TC.println();
		return;
	}
	
	public static int[] tableauOrdonne(int n) {
		int[] tab;
		tab= new int[n];
		for(int i=0; i<n; i++) {
			tab[i]=i+1;
		}
		return tab;
	}
	
	public static void echange(int[] t, int i, int j){
		  int a=t[i];
		  int b=t[j];
		  t[j]=a;
		  t[i]=b;
		  
		  
		}

	public static void melangeTableau(int[] tab){
		  for(int i=tab.length-1; i>0; i--){
		    int j=(int)(Math.random()*(i+1));
		    echange(tab, j, i);
		  }
		
		}
	
	public static boolean estUnePermutation(int[] tab) {
		int[] comp=new int[tab.length];
		for(int i=0; i<tab.length; i++){
			comp[i]=0;
		}
		for(int i=0; i<tab.length; i++) {
			if(tab[i]<1||tab[i]>tab.length) return false;
			else if(comp[tab[i]-1]==0)
				comp[tab[i]-1]=1;
			else return false;
		}
		return true;
		
	}
	
	public static int[] tourSuivant(int[] tab, boolean[] result){
		int[] tab2=new int[tab.length/2];
		for(int i=0; i<tab2.length; i++){
			if(result[i])
				tab2[i]=tab[2*i];
			else tab2[i]=tab[2*i+1];
		}
		return tab2;
	}
	
	public static int vainqueur(int[] tab, boolean[][] result){
		int nbjoueur=tab.length;
		int tour=0;
		while(nbjoueur>1){
			afficheTour(tab);
			tab=tourSuivant(tab,result[tour]);
			tour++;
			nbjoueur/=2;
		};
		return tab[0];
	}
	public static int[] tourPrecedent(int[] tab){
		int[] tourP=new int[2*tab.length];
		for(int i=0; i<tab.length; i++){
			tourP[2*i]=tab[i];
			tourP[2*i+1]=tourP.length+1-tab[i];
		}
		return tourP;
	}
	
	public static int[] tableauRealiste(int n){
		if(n==1){
			int[] tab=new int[] {1};
			return tab;
		}
		int[] tab=new int[] {1,2};
		int nbjoueur=2;
		while(nbjoueur<n){
			tab=tourPrecedent(tab);
			nbjoueur*=2; 
		}
		return tab;
	}
	
	public static boolean vainqueurMatch(int i, int j){
		double prob=Math.random();
		double I=i*1.0;
		boolean re=(prob>I/(I+j));
		return re;
	}
	
	public static boolean[][] resultatsRealistes(int[] tab){
		boolean[][] result;
		int nbtour=log2(tab.length);
		result=new boolean[nbtour][];
		for(int tour=0;tour<nbtour;tour++){
			boolean[] tmp=new boolean[tab.length/2];
			for(int i=0; i<tab.length/2; i++){
				tmp[i]=vainqueurMatch(tab[2*i],tab[2*i+1]);
			}
			result[tour]=tmp;
			tab=tourSuivant(tab,result[tour]);
		}
		
		
		return result;
			
	}
}
