import tc.TC;

/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * 
 */
public class TestSortingRationals {
	
	public static void main(String args[]) {
		RationalNumber[] numbers=RationalNumber.randomNumbersInInterval(1000, 1000, 10);
		//RationalNumber.printNumbers(numbers);
		Draw d1=new Draw("Rationnels aleatoires", 10000, 400);
		d1.draw(numbers);
		
		// choose implementation
		SortingAlgorithm algo; 
		//algo=new SelectionSort(numbers, new RationalComparator());
		algo=new InsertionSort(numbers, new RationalComparator());
		//algo=new MergeSort(numbers, new RationalComparator());
		
		// perform sorting
		algo.run();
		
		// printing output
		TC.println("Voici les nombres tries (en ordre croissant)");
		RationalNumber.printNumbers(numbers);
		
		Draw d2=new Draw("Nombres tries", 10000, 400);
		d2.draw(numbers);
	}

}
