/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2014)
 * Interface of an element comparator
 */
public interface ElementComparator {
	
	public static final int SMALLER=-1;
	public static final int LARGER=1;
	public static final int EQUAL=0;

	public int compare(Element a, Element b);

}
