import tc.TC;
import java.lang.management.*;

public class TestExercice6 {
	
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
	
	public static void test(String nom, int nmots, int nlignes, int iterations) {		
		TC.println("Test: " + nom + ". " + iterations + "x(" + nmots + " mots, " + nlignes + " lignes)");
		
		long deltaWC[] = new long[iterations];
		long deltaCpu[] = new long[iterations];
		long deltaUser[] = new long[iterations];
		long deltaSys[] = new long[iterations];
		
		long avWC = 0;
		long avCpu = 0;
		long avUsr = 0;
		long avSys = 0;
		
		for(int i = 0; i < iterations; i++) {
			long WC = getWallClockTime( );
			long Cpu = getCpuTime( );
			long Sys = getSystemTime( );
			long Usr = getUserTime( );
			
			TC.lectureDansFichier(nom + ".txt");
			Index I = new Index(nom);
			I.ajouterTexte( );
			I.imprimer( );
			I.estOrdonne( );
			
			deltaWC[i] = getWallClockTime( ) - WC;
			deltaCpu[i] = getCpuTime( ) - Cpu;
			deltaUser[i] = getUserTime( ) - Usr;
			deltaSys[i] = getSystemTime( ) - Sys;
		}
		
		for(int i = 0; i < iterations; i++) {
			avWC += deltaWC[i];
			avCpu += deltaCpu[i];
			avUsr += deltaUser[i];
			avSys += deltaSys[i];
		}
		avWC /= (iterations*1000000);
		avCpu /= (iterations*1000000);
		avUsr /= (iterations*1000000);
		avSys /= (iterations*1000000);
		
		TC.ecritureSortieStandard( );
		TC.println("Temps (moyen) :");
		TC.println("  Wall-clock delta = " + avWC + "ms");
		TC.println("         Cpu delta = " + avCpu + "ms");
		TC.println("        User delta = " + avUsr + "ms");
		TC.println("      System delta = " + avSys + "ms");

		TC.println("COMPARER " + nom + ".index et " + nom + ".index.ref");
		TC.println( );
	}
	
	public static void main(String[] args) {
		// grec
		// test("grec", 13, 3, 100);
		// verne		
		// test("verne", 433, 49, 1000);
		// zola
		test("zola", 4330, 387, 100);
		// rousseau
		test("rousseau", 10096, 948, 100);
		// proust
		test("proust", 165896, 12855, 10);
	}
}
