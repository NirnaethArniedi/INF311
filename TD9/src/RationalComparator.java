/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * An implementation of a comparator for rational numbers
 */
public class RationalComparator implements ElementComparator {

  public int compare(Element ea, Element eb) {
	  RationalNumber a=(RationalNumber)ea;
	  RationalNumber b=(RationalNumber)eb;
	  int lhs = a.getNum() * b.getDen();
	  int rhs = a.getDen() * b.getNum();
	  if (lhs < rhs) return SMALLER;
	  else if(lhs==rhs) return EQUAL;
	  else return LARGER;
  }
}