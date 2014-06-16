import java.awt.Color;
import tc.TC;
/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * Class for testing sorting algorithms on points clouds
 */
public class TestSortingPoints {

	public static void main(String args[]) {
		int windowSize=200;
		SortingAlgorithm algo; // algorithm for sorting points in the plane
		ElementComparator cX; // the comparator for points
		
		Point2D[] points=Point2D.randomPointsInSquare(20, windowSize, 10); // random points in a square

		cX=new CoordinateComparatorX(); // choice of the comparator
		
		algo=new SelectionSort(points, cX); // selection sort, increasing x coordinates
		//algo=new InsertionSort(points, cX); // insertion sort, increasing x coordinates
		//algo=new MergeSort(points, cX); // mergesort, increasing x coordinates
		
		TC.println("Voici les points tries par rapport a leur abscisse croissante");
		algo.run();
		Point2D.printPoints(points);

		Draw d=new Draw("Tri de points", windowSize, windowSize);
		d.draw(points);
		d.drawPolyline(points, Color.black);
	}

}
