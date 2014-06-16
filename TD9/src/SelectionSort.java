public class SelectionSort implements SortingAlgorithm {

	final ElementComparator c; // comparator defining a total order
	final Element[] t; // array of elements to sort

	//Draw d = new Draw("SelectionSort", 200, 200); // utile pour les dessins

	public SelectionSort(Element[] t, ElementComparator c) {
		this.t = t;
		this.c = c;
		//d.draw(t);
	}

	public void swap(int i, int j) {
		Element temp = this.t[i];
		this.t[i] = this.t[j];
		this.t[j] = temp;
	}

	public void run() {
	}
	
}
