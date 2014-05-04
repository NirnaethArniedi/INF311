import tc.TC;

public class Binaire {

  /**
   * Calcule le bit 0 de l'entier argument.
   * 
   * @param n
   *          l'entier
   * @return 0 ou 1 pour le bit correspondant
   */
	
public static int log2(int n){
		
		int k=0;
		while(n/2>0){
			n/=2;
			k+=1;
		}
		return k;
	}

  public static int b0(int n) {
	  int bit;
	  if (n%2==0) {
		  bit=0;
	  }
	  else {
		  bit=1;
	  }
	  return bit; // MODIFIER pour la valeur de retour correcte
  }

  public static int b1(int n) {
	  int bit;
	  int nu;
	  nu=n%4;
	  if (nu/(2)==0) {
			bit=0;
		}
		else {
			bit=1;
		}
	  
	  return bit; // MODIFIER pour la valeur de retour correcte
  }

  public static int b2(int n) {
	  int bit;
	  int nu;
	  nu=n%8;
	  if (nu/(2*2)==0) {
			bit=0;
		}
		else {
			bit=1;
		}
	  return bit; // MODIFIER pour la valeur de retour correcte
  }

  public static int b3(int n) {
	int Bit;
	if (n/(2*2*2)==0) {
		Bit=0;
	}
	else {
		Bit=1;
	}
    return Bit; // MODIFIER pour la valeur de retour correcte
  }
//Autre méthode, récursive :
  
  public static void bit(int n, int[] tab,int k){
	  if(n>1){
		  bit(n/2, tab, k-1);
		  tab[k]=(n%2);
	  }
	  else if(n==1) tab[k]=1;
	  else tab[k]=0;
	  return;
  }
  
  
  
  public static int[] decBin(int n){
	  int nbBit=log2(n);
	  int k=0;
	  int[] base2=new int[nbBit];
	  bit(n,base2,k);
	  return base2;
  }
	  
	  
  public static void main(String[] args) {
    for (int n = 0; n < 16; ++n)
      TC.println("" + b3(n) + b2(n) + b1(n) + b0(n) + " = " + n);
    
  }
}
