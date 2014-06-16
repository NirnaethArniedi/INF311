import tc.TC;

public class TestRationals {

	public static void main(String args[]) {
		Element[] numbers=RationalNumber.randomNumbersInInterval(20, 200, 10);
		ElementComparator c=new RationalComparator();
		
		for(int i=0;i<numbers.length;i++)
			TC.println(numbers[i]);
		
		for(int i=1;i<numbers.length;i++) {
		      TC.print(numbers[i-1]);
		      if(numbers[i-1].isSmaller(numbers[i], c))
		        TC.print(" < ");
		      else
		        TC.print(" >= ");
		      TC.println(numbers[i]);
		}
		
		Draw d1=new Draw("Rationnels aleatoires", 200, 200);
		d1.draw(numbers);
	}

}
