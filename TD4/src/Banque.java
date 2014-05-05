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
	
	/////////////////////////////////////
	
	public Argent soldeDeCompte(long numero){
		int i=trouverCompte(numero);
		if(i==-1)
			return null;
		else
			return this.comptes[i].solde;
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
	
	public boolean deposer(long n, ArgentPhysique ap){
		int i = trouverCompte(n);
		if(i == -1){
			return false;
		}
		else{
			comptes[i].solde=comptes[i].solde.plus(ap.montant());
			return true;
		}
	}
	/*
	public boolean deposer(long n, Argent montant){
		int i=trouverCompte(n);
		if(i==-1){
			return false;
		}
		comptes[i].solde=comptes[i].solde.plus(montant);
		return true;
	}
	**/
	
	
	public Liquide retirer(long n, Argent montant){
		int i=trouverCompte(n);
		if(i==-1){
			return null;
		}
		else if(comptes[i].solde.estPlusGrandQue(montant)||comptes[i].solde.equals(montant)){
			if(comptes[i].limite==null||comptes[i].limite.estPlusGrandQue(comptes[i].retraitCumulatifAujourdhui.plus(montant))||comptes[i].limite.equals(comptes[i].retraitCumulatifAujourdhui.plus(montant))){
				comptes[i].solde=comptes[i].solde.moins(montant);
				comptes[i].retraitCumulatifAujourdhui=comptes[i].retraitCumulatifAujourdhui.plus(montant);
				Liquide som=new Liquide(montant);
				return som;
			}
			else{
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public Argent getLimite(long numeroClient){
		int i=trouverCompte(numeroClient);
		if(i==-1){
			return null;
		}
		else{
			return comptes[i].limite;
		}
	}
	
	public void setLimite(long numeroClient, Argent limite){
		int i =trouverCompte(numeroClient);
		if(!(i==-1)){
			comptes[i].limite=limite;
		}
	}
	
	public void setLimiteGlobale(Argent limite){
		for(int i=0; i<comptes.length;i++){
			if(comptes[i]!=null){
				comptes[i].limite=limite;
			}
		}
	}
	
	public void minuit(){
		for(int i=0; i<comptes.length;i++)
			if(comptes[i]!=null){
				comptes[i].retraitCumulatifAujourdhui=new Argent("0.0");
			}
	}
	

    public static final char APPROUVE = 'A';
    public static final char EMETTEUR_INCONNU = 'E';
    public static final char DESTINATAIRE_INCONNU = 'D';
    public static final char SOLDE_INSUFFISANT = 'S';
    public static final char LIMITE_ATTEINTE = 'L'; 
	
	public char virer(long emetteur, long dest, Argent montant){
		int em=trouverCompte(emetteur);
		int de=trouverCompte(dest);
		if(em==-1)
			return EMETTEUR_INCONNU;
		if(de==-1)
			return DESTINATAIRE_INCONNU;
		if(montant.estPlusGrandQue(comptes[em].solde))
			return SOLDE_INSUFFISANT;
		if(!(comptes[em].limite==null||(comptes[em].limite.estPlusGrandQue(comptes[em].retraitCumulatifAujourdhui.plus(montant))||comptes[em].limite.equals(comptes[em].retraitCumulatifAujourdhui.plus(montant))))){
				return LIMITE_ATTEINTE;
		}
		else{
			comptes[em].solde=comptes[em].solde.moins(montant);
			comptes[em].retraitCumulatifAujourdhui=comptes[em].retraitCumulatifAujourdhui.plus(montant);
			comptes[de].solde=comptes[de].solde.plus(montant);
			return APPROUVE;
		}
	}
}