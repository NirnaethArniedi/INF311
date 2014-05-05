import tc.TC;
public class Argent {
	// représentation interne de l'argent:
	private final long valeur;
	
	public Argent(long euros, int centimes) {
		this.valeur = 100*euros + centimes;
	}
	public Argent(String str){
		String[] val=TC.decoupage(str,'.');
		int centime=Integer.parseInt(val[1]);
		long eur=Long.parseLong(val[0]);
		this.valeur = 100*eur + centime;
		
	}
	// utile pour l'exercice 10
	public Argent(long c) {
		this.valeur = c;
	}

	public long euros( ) {
		long e=this.valeur;// __COMPLETER__
		return e/100;
	}
	
	public int centimes( ) {
		long diff= this.valeur-100*this.euros();// __COMPLETER__
		int centime= (int) diff;
		return centime;
	}
	
	public String toString( ) {
		if(this.centimes()>9)
			return this.euros() + "."+this.centimes();
		else
			return this.euros()+"."+"0"+this.centimes();
    }
	
	public boolean equals(Argent x){
		if(x==null) return false;
		else if(x.valeur==this.valeur) return true;
		else return false;
	}
	
	public Argent plus(Argent x){
		long c=this.valeur+x.valeur;
		Argent a=new Argent(c);
		return a;
	}

	public Argent moins(Argent x){
		long c=this.valeur-x.valeur;
		Argent a=new Argent(c);
		return a;
	}
	
	public boolean estPlusGrandQue(Argent x){
		return(this.valeur>x.valeur);
	}
}

