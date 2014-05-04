import tc.TC;
public class Test1Recursivite {
	public static int f(int n) {
		if(n>100)
			return n-10;
		else
			return f(f(n+11));
	}
	public static void main(String[] args){
		TC.println(f(89));
		
	}
}
