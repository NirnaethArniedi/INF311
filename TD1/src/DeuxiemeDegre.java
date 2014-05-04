import tc.TC;

public class DeuxiemeDegre {
	
	
  public static void poly(double a, double b, double c){
	  double Dis=(b*b-4*a*c);
	  TC.println("Discriminant : "+Dis);
	  if (Dis<0) {
		  TC.println("Pas de solutions");
		  return;
	  }

	  else{
		  if (Dis==0) {
			  double raci=-b/(2*a);
			  TC.println("Une racine double : "+raci);
			  return;
		  }
		  else {
			  double sq=Math.sqrt(Dis);
			  double ra1=((-b-sq)/(2*a));
			  double ra2=((-b+sq)/(2*a));
			  TC.println("Deux racines : "+ra1 +" "+ ra2);
			  return;
		  }
	  }
	  
	}
	
	public static void main(String[] args) {
		TC.print("Entrer a b c : ");
		double a=TC.lireDouble();
		double b=TC.lireDouble();
		double c=TC.lireDouble();
		poly(a,b,c);
		return;
	}
	
}