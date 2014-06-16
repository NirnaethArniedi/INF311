import java.awt.Color;
import tc.TC;

/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * 
 */
public class TestRangeSearch {

	public static void main(String args[]) {
		int windowSize=200;
		Point2D[] points=Point2D.randomPointsInSquare(15, windowSize, 7); // random points in a square
		Point2D q=new Point2D(122., 120);
		Element[] range;
		
		SortingAlgorithm algo; // the sorting algorithm
		ElementComparator cX=new CoordinateComparatorX(); // the comparator (along x axis)
		Search search=new Search(cX);

		algo=new SelectionSort(points, cX); // selection sort, increasing x coordinates
		algo=new InsertionSort(points, cX); // insertion sort, increasing x coordinates
		//algo=new MergeSort(points, cX); // merge sort, increasing x coordinates
		
		algo.run();
		int index=search.rangeSearch(points, q, 0, points.length); // first bound of the interval
		if(index>=0){
				range=Point2D.extractInterval(points, index, points.length);
		
		Draw d1=new Draw("Points", windowSize, windowSize);
		d1.draw(points);
		d1.drawPolyline(new Point2D[] {new Point2D(q.getX(),0), new Point2D(q.getX(), 200)}, Color.red);
		
		Draw d2=new Draw("Range", windowSize, windowSize);
		d2.draw(range);
		
		TC.println("Points en entree: ");
		Point2D.printPoints(points);
		TC.println("Point requete: "+q);
		TC.println("Les points avec coordonnees plus grandes ou egales sont");
		for(int i=0;i<range.length;i++)
			System.out.println(""+range[i]);}
	}

}
