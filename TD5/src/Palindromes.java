import tc.TC;
public class Palindromes{

    public static boolean estPalindrome(String mot){
        return estPalindrome(mot,0,mot.length()-1);
    }

    public static boolean estPalindrome(String mot, int g, int d){
        //À compléter
	return false;
    }

    public static void traiter(){
 	//À compléter
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
