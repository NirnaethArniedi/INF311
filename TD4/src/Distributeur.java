public class Distributeur implements Quotidien{
    public String nom;
    private Banque banque;
    private final long numeroDistributeur;
    public final Liquide capacite;
    private Liquide billets;
     
    public Distributeur(Horloge h,Banque b, String nom, long numeroDistributeur, Liquide capacite) {
        this.nom = nom;
        this.banque = b;
        this.numeroDistributeur = numeroDistributeur;
        assert(this.banque.aCompte(this.numeroDistributeur));
        this.capacite = capacite;
        this.recharger( );
        h.inscrire(this);
    }
    
    private void recharger( ) {
    	this.billets = this.capacite;
    }
    
    public String toString( ) {
        return "DISTRIBUTEUR " + this.nom + " de " + this.banque + " (" + this.billets + ")";
    }
    
    public String consulter(long numCli){
    	boolean vr=banque.aCompte(numCli);
    	if(vr==false){
    		return "Il n'y a pas de compte #"+numCli+" chez "+this.banque.toString()+"." ;
    	}
    	else{
    		String SOLDE=banque.soldeDeCompte(numCli).toString( );
    		return "Le solde du compte #"+numCli+" est "+SOLDE+" euros." ;
    	}
    }
    
    public Retrait retirer(long n,Argent a){
    	Argent zeroA=new Argent(0,0);
    	Liquide zeroL=new Liquide(zeroA);
    	char test=banque.virer(n,this.numeroDistributeur,a);
    	if(billets.montant().equals(zeroA)||billets.prelever(a)==null){
    		Retrait ret=new Retrait("Désolé, on ne peut pas distribuer " + a +" euros.",zeroL);
    		return ret;
    	}
    	if(test=='S'){
    		Retrait ret=new Retrait("Désolé, le solde du compte #"+n+" est insuffisant.",zeroL);
    		return ret;
    	}
    	if(test=='E'){
    		Retrait ret=new Retrait("Désolé, le compte #"+n+" est inconnu chez "+banque.toString()+".",zeroL);
    		return ret;
    	}
    	if(test=='L'){
    		Retrait ret=new Retrait("Désolé, un retrait de montant "+a+" depasserait votre limite de retrait quotidien.",zeroL);
    		return ret;
    	}
    	else if(test=='A'){
    		Retrait ret=new Retrait("Veuillez prendre votre argent.",this.billets.prelever(a)[0]);
    		this.billets=this.billets.prelever(a)[1];
    		return ret;
    	}
    	return null;
    }
    
    public void minuit(){
    	recharger();
    }
    
    
}
