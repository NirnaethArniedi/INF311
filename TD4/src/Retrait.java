public class Retrait {
	public final String message;
	public final Liquide montant;
	
	public Retrait(String message, Liquide montant) {
		this.message = message;
		this.montant = montant;
	}

	public String toString( ) {
		return message + " [" + montant + "]";
	}
}
