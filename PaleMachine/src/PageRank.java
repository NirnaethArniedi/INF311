import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import tc.TC;


public class PageRank {

	static PageWeb[] web;
	static private Map<PageWeb, Integer> idx;
	static private int[] ranks;
	static private Random gen;
	
	public static void calculeEtRemplit(PageWeb[] g){
		web=g;
		idx=new HashMap<PageWeb, Integer>();
		for(int i=0; i<g.length; i++) idx.put(web[i], i);
		ranks=new int[g.length];
		gen=new Random(645234141);
		calcule(50);
		remplitChamps();
	}
	
	private static void calcule(int steps){
		int n=web.length;
		for(int i=0; i<steps; i++){
			int curr=gen.nextInt(n);
			for(int j=0; j<n*steps; j++){
				ranks[curr]++;
				int next=gen.nextInt(web[curr].getNombreLiens());
				curr=idx.get(web[curr].getLien(next));
			}
		}
	}
	
	private static void remplitChamps(){
		for(PageWeb p:idx.keySet())
			p.setPageRank(ranks[idx.get(p)]);
	}
	
	public static void testScores(PageWeb[] web, String mot){
		for(int k=0; k<web.length; k++)
			TC.println("MOT="+mot+" URL="+web[k].getUrl()+" SCORE="+web[k].score(mot));
	}
	
	

	
}
