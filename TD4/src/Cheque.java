public class Cheque implements ArgentPhysique {

	public final long euros;
	public final int centimes;
	public final String signature;
	
	public Cheque(Argent a, String signature) {
		this.euros = a.euros( );
		this.centimes = a.centimes( );
		this.signature = signature;
	}

    public Argent montant( ) {
        Argent valeur = new Argent(this.euros,this.centimes);
        return valeur;
    }
	
	public String toString( ) {
		return "CHEQUE pour " + euros + " euros et " + centimes + " centimes de " + signature;
	}

}
