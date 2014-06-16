/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * A generic interface defining methods provided by a sorting algorithm
 *
 */
public interface SortingAlgorithm extends Runnable {

	/**
	 * Sort elements (according to a given total order, defined by Comparator)
	 *
	 */
	public void run();
	
}
