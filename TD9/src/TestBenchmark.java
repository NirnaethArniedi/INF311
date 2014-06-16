import tc.TC;
import java.lang.management.*;
import java.awt.Color;

public class TestBenchmark {
	/** get CPU time in nanoseconds. */
	public static long getCpuTime( ) {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	    if(!bean.isCurrentThreadCpuTimeSupported( )) {
	    	System.out.println("Warning: getCpuTime not supported");
	    	return 0L;
	    }
	    return bean.getCurrentThreadCpuTime( );
	}
	 
	/** Get user time in nanoseconds. */
	public static long getUserTime( ) {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	    if(!bean.isCurrentThreadCpuTimeSupported( )) {
	    	System.out.println("Warning: getUserTime not supported");
	    	return 0L;
	    }	
	    return bean.getCurrentThreadUserTime( );
	}

	/** Get system time in nanoseconds. */
	public static long getSystemTime( ) {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	    if(!bean.isCurrentThreadCpuTimeSupported( )) {
	    	System.out.println("Warning: getSystemTime not supported");
	    	return 0L;
	    }
	    return bean.getCurrentThreadCpuTime( ) - bean.getCurrentThreadUserTime( );
	}
	
	/** Get wall-clock time in nanoseconds. */
	public static long getWallClockTime( ) {
		return System.nanoTime( );
	}
	
	public static double test(SortingAlgorithm algo, int n) {
		long WC = getWallClockTime( );
		long Cpu = getCpuTime( );
		//long Sys = getSystemTime( );
		//long Usr = getUserTime( );
			
		
		algo.run(); // run the sorting algorithm
			
		long deltaWC = getWallClockTime( ) - WC;
		long deltaCpu = getCpuTime( ) - Cpu;
		//long deltaUser = getUserTime( ) - Usr;
		//long deltaSys = getSystemTime( ) - Sys;

		//TC.println("Temps (moyen):");
		TC.println("  Wall-clock delta = " + deltaWC + "ns");
		TC.println("         Cpu delta = " + deltaCpu + "ns");
		//TC.println("        User delta = " + deltaUser + "ns");
		//TC.println("      System delta = " + deltaSys + "ns");
		
		return deltaCpu/(double)n;
	}
	
	public static void main(String[] args) {
		int n=15;
		double[] timings=new double[n];
		Point2D[] graph=new Point2D[n];
		SortingAlgorithm algo;
		
		for(int i=1;i<=n;i++) {
			RationalNumber[] numbers=RationalNumber.randomNumbersInInterval(5000*i, 1000, 10);
			
			//algo=new SelectionSort(numbers, new RationalComparator());
			//algo=new InsertionSort(numbers, new RationalComparator());
			algo=new MergeSort(numbers, new RationalComparator());

			timings[i-1]=test(algo, numbers.length);
			graph[i-1]=new Point2D(10.*i, 200.-timings[i-1]/1000.);
			System.out.println("Average time (per number): "+timings[i-1]+" ns");
		}
		Draw d=new Draw("Benchs", 200, 200);
		d.drawPolyline(graph, Color.red);
	}

}
