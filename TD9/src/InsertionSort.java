/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2014) 
 * 
 * This class provides an implementation of insertion sorting algorithm
 */
public class InsertionSort implements SortingAlgorithm {

	final ElementComparator c; // comparator defining a total order
	final Element[] t; // array of elements to sort
	Draw d = new Draw("InsertionSort", 200, 200); // useful for drawings and
													// animations
	public InsertionSort(Element[] t, ElementComparator c) {
		this.t = t;
		this.c = c;
		d.draw(t);
	}

	/**
	 * Copy the input element e at position k in the array this.t
	 */
	public void replace(int k, Element e) {
		d.erase(k, t[k]);
		t[k] = e; // recopie finale
		d.blink(k, t[k]);
	}

	public void run() {
	}
	
}
