import tc.TC;
public class Banque {
	public final String nom;
	private final Compte[] comptes;
	private int nombreDeComptes;
	public Banque(String nom, int maxComptes){
		this.nom=nom;
		this.comptes=new Compte[maxComptes];
	}
	
	public String toString( ){
		return "BANQUE "+this.nom;
		
	}
	
	public int trouverCompte(long numero){
		for(int i=0; i<this.comptes.length;i++){
			if(this.comptes[i]!=null&&numero==this.comptes[i].numero)
				return i;
		}
		return -1;
	}
	
	public boolean aCompte(long numero){
		if(this.trouverCompte(numero)==-1) return false;
		else return true;
	}
	
	public boolean ajouterCompte(Compte c){
		if(this.nombreDeComptes!=this.comptes.length&&!aCompte(c.numero)){
			this.comptes[this.nombreDeComptes]=c;
			this.nombreDeComptes+=1;
			return true;
		}
		return false;
	}
	
	public Argent soldeDeCompte(long numero){
		if(trouverCompte(numero)==-1)
			return null;
		else
			return this.comptes[trouverCompte(numero)].solde;
	}
	
	public void afficher( ){
		TC.println(this.nom);
		TC.println(this.nombreDeComptes);
		for(int i=0; i<this.comptes.length;i++){
			if(this.comptes[i]!=null)
				TC.println(this.comptes[i]);
		}
	}
	
	public static Banque lireBanque( ){
		Banque bank;
		bank=new Banque(TC.lireLigne(),Integer.parseInt(TC.lireLigne( )));
		
		for(int i=0; i<bank.comptes.length;i++){
			Compte c=new Compte(TC.lireLigne());
			bank.ajouterCompte(c);
		}
		return bank;
	}
	
	public boolean deposer(long n, Argent montant){
		int i=trouverCompte(n);
		if(i==-1){
			return false;
		}
		comptes[i].solde=comptes[i].solde.plus(montant);
		return true;
	}
	
	public boolean retirer(long n, Argent montant){
		int i=trouverCompte(n);
		if(i==-1){
			return false;
		}
		else if(comptes[i].solde.estPlusGrandQue(montant)||comptes[i].solde.equals(montant)){
			comptes[i].solde=comptes[i].solde.moins(montant);
			return true;
		}
		else {
			return false;
		}
	}
}
