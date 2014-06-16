/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2014)
 * Interface providing basic methods for dealing with
 * a set of elements endowed with a total order
 */
public interface Element {

    /**
     * Check whether the current element is smaller than e,
     * according to the order defined by c
     * 
     * @param e element to be compared
     * @param c comparator (defining a total order on the elements)
     * @return true whether current object 'this' is smaller than e
     */
	public boolean isSmaller(Element e, ElementComparator c);

    /**
     * Check whether the current element is equal to e
     */
	public boolean equals(Element e);

    /**
     * Return a String representation for the element
     */
	public String toString();
    
	/**
     * Paint the element in a graphic frame
     */
	public void paint(Draw d, int i);
		
}
