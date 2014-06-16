/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * 
 */
public class TestBinarySearch {

	public static void main(String args[]) {
		int windowSize=200;
		Point2D[] points=Point2D.randomPointsInSquare(30, windowSize, 7); // random points in a square
		Point2D[] bounds=Point2D.randomPointsInSquare(2, windowSize, 7); // random points in a square
		Element[] range;
		
		SortingAlgorithm algo; // the sorting algorithm
		ElementComparator cX=new CoordinateComparatorX(); // the comparator (along x axis)
		Search search=new Search(cX);

		//algo=new SelectionSort<Point2D>(points, cX); // selection sort, increasing x coordinates
		//algo=new InsertionSort<Point2D>(points, cX); // insertion sort, increasing x coordinates
		algo=new MergeSort(points, cX); // merge sort, increasing x coordinates
		
		algo.run();
		int lower=search.binarySearch(points, bounds[0], 0, points.length); // first bound of the interval
		int upper=search.binarySearch(points, bounds[1], 0, points.length); // second bound of the interval
		if(lower<upper)
			range=Point2D.extractInterval(points, lower, upper);
		else
			range=Point2D.extractInterval(points, upper, lower);
		
		Draw d1=new Draw("Points", windowSize, windowSize);
		d1.draw(points);
		
		Draw d2=new Draw("Intervalle", windowSize, windowSize);
		d2.draw(range);
	}

}
