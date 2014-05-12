public class TestDecryptage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String msgCrypte="TSEIIERSOTCFCTNRIUEU";
		int tailleCle=5;
		
		Decryptage.decodeToutes(msgCrypte, tailleCle);
		//Decryptage.decodeToutesUneParUne(msgCrypte, tailleCle);
	}

}
