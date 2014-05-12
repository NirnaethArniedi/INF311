import tc.TC;
public class Palindromes{

    public static boolean estPalindrome(String mot){
        return estPalindrome(mot,0,mot.length()-1);
    }

    public static boolean estPalindrome(String mot, int g, int d){
    	if(mot.length()==0)
    		return true;
    	boolean test=mot.charAt(g)==mot.charAt(d);
    	if(g >= d)
    		return true;
    	if(g == d)
    		return true;
    	if(test)
    		return(estPalindrome(mot,g+1,d-1));
    	return false;
    }

    public static void traiter(){
    	String ligne1 = TC.lireLigne();
    	int n = Integer.parseInt(ligne1);
    	for(int i = 0; i<n; i++){
    		String mot = TC.lireLigne();
    		if(estPalindrome(mot))
    			TC.println(mot);
    	}
	return;
    }

    public static void testPalindrome(String mot){
        if(estPalindrome(mot)){
            TC.println(mot + " est un palindrome");
        }
        else{
            TC.println(mot + " n'est pas un palindrome");			
        }
    }
	
    public static void main(String[] args){
        testPalindrome("AB");
        testPalindrome("BAOBAB");
        testPalindrome("KAYAK");
        testPalindrome("ABBA");
        testPalindrome("BOBAR");
        testPalindrome("ESOPERESTEICIETSEREPOSE");
    }

}
