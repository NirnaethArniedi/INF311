/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * Class for testing 3 different sorting algorithms: insertion sort, selection sort and merge sort
 */
public class TestingAllAlgorithms {

	
	public static void main(String args[]) {
		RationalNumber[] numbers1=RationalNumber.randomNumbersInInterval(50, 200, 10);
		RationalNumber[] numbers2=new RationalNumber[numbers1.length];
		RationalNumber[] numbers3=new RationalNumber[numbers1.length];
		
		Draw d1=new Draw("Rationnels aleatoires", 200, 200);
		d1.draw(numbers1);

		for(int i=0;i<numbers1.length;i++) {
			numbers2[i]=new RationalNumber(numbers1[i].getNum(), numbers1[i].getDen());
			numbers3[i]=new RationalNumber(numbers1[i].getNum(), numbers1[i].getDen());
		}
		
		new Thread(new InsertionSort(numbers2, new RationalComparator())).start();
		new Thread(new SelectionSort(numbers1, new RationalComparator())).start();
		new Thread(new MergeSort(numbers3, new RationalComparator())).start();
	}

}
