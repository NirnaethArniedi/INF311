import java.awt.Color;

import tc.TC;

/**
 * @author Luca Castelli Aleardi (Ecole Polytechnique, INF311, 2013)
 * Class for testing sorting algorithms on points clouds
 */
public class TestClosestPair {

	public static void main(String args[]) {
		int windowSize=200;
		Point2D[] points=Point2D.randomPointsInSquare(20, windowSize, 20); // generate points at random in a square
		//Point2D.printPoints(points); // print points (before sorting)
		
		ClosestPair cp1=new BruteForceClosestPair();
		Draw d1=new Draw("Algo naif", windowSize, windowSize);
		d1.draw(points);
		Point2D[] closestPoints1=cp1.computeClosestPair(points);
		d1.drawPolyline(closestPoints1, Color.black);

		ClosestPair cp2=new FastClosestPair(points);
		Draw d2=new Draw("Algo rapide", windowSize, windowSize);
		d2.draw(points);
		Point2D[] closestPoints2=cp2.computeClosestPair(points);
		d2.drawPolyline(closestPoints2, Color.black);
		TC.println("points les plus proches (algo rapide): "+closestPoints2[0]+" - "+closestPoints2[1]);
		TC.println("points les plus proches (algo naif): "+closestPoints1[0]+" - "+closestPoints1[1]);
	}

}
