public class Distributeur {
    public String nom;
    private Banque banque;
    private final long numeroDistributeur;
    public final Liquide capacite;
    private Liquide billets;
     
    public Distributeur(Banque b, String nom, long numeroDistributeur, Liquide capacite) {
        this.nom = nom;
        this.banque = b;
        this.numeroDistributeur = numeroDistributeur;
        assert(this.banque.aCompte(this.numeroDistributeur));
        this.capacite = capacite;
        this.recharger( );
    }
    
    private void recharger( ) {
    	this.billets = this.capacite;
    }
    
    public String toString( ) {
        return "DISTRIBUTEUR " + this.nom + " de " + this.banque + " (" + this.billets + ")";
    }
}
