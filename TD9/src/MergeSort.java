/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2014) 
 * This class provides an implementation of the merge sorting algorithm (in place version)
 * Element comparisons are performed by the ElementComparator interface
 */
public class MergeSort implements SortingAlgorithm {

	final ElementComparator c; // the comparator defining a total order
	final Element[] t; // array storing elements to sort
	Draw d1 = new Draw("Merge sort", 200, 200);
	Draw d2 = new Draw("Merge sort", 200, 200);

	public MergeSort(Element[] t, ElementComparator c) {
		this.t = t;
		this.c = c;
		d1.draw(t);
	}

	/**
	 * Copy the input element e at position k in the array this.t
	 */
	public void replace(int k, Element e) {
		d1.erase(k, t[k]); // add comments for benchmarks
		t[k] = e; // recopie finale
		d1.blink(k, t[k]); // add comments for benchmarks
	}
	
	public void run() {
	}

	public void runRec(int g, int d) {
	}

	public void merge(int g, int m, int d) {
	}

}
