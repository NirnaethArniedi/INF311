import tc.TC;

public class Arithmetique {

  static int eval() {
	  char c=TC.lireChar();
	  if(Character.isDigit(c)){
		  int d=Character.digit(c,10);
		  return d;
	  }
	  else{
		int e1=eval();
		TC.lireChar();
		char op= TC.lireChar();
		TC.lireChar();
		int e2=eval();
		TC.lireChar();
		switch(op){
		  	case'+':
		  		return e1+e2;
		  	case'-':
				return e1-e2;
  			case'*':
  				return e1*e2;
			case'%':
				return e1%e2;
			case'/':
				return e1/e2;
			}
	  }
	  return -300000000;
  }
}