public class Liquide {
	private static final long[] VALS = new long[]{
		10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1
	};

	private final long[] coeffs;

	public Liquide(Argent a) {
		this.coeffs = new long[13];
		long e = a.euros( );
		for(int i = 0; i < 7; i++) {
			this.coeffs[i] = e/(VALS[i]/100);
			e %= (VALS[i]/100);
		}
		int c = a.centimes( );
		for(int i = 7; i < 13; i++) {
			this.coeffs[i] = c/VALS[i];
			c %= VALS[i];
		}
	}

    public Argent montant( ) {
        // __ COMPLETER__
        return null;
    }

	public String toString( ) {
		String res = "";
		for(int i = 0; i < 13; i++) {
			if(coeffs[i] == 0)
				continue;
			if(! res.equals(""))
				res += ", ";
			res += coeffs[i] + (i < 5 ? " billet" : " piece")
					+ (coeffs[i] > 1 ? "s de " : " de ");
			if(i < 7)
				res += (VALS[i]/100) + " euro" + (i != 6 ? "s" : "");
			else
				res += VALS[i] + " centime" + (i != 12 ? "s" : "");
		}
		if(res.equals(""))
			return "pas de liquide";
		return res;
	}	
	
	private Liquide(long[] coeffs) {
		assert(coeffs.length == 13);
		this.coeffs = coeffs;
	}
	
	public Liquide plus(Liquide x) {
		long[] rCoeffs = new long[13];
		for(int i = 0; i < 13; i++)
			rCoeffs[i] = this.coeffs[i] + x.coeffs[i];
		return new Liquide(rCoeffs);
	}
	
    public Liquide fois(long n) {
        long[] rCoeffs = new long[13];
        for(int i = 0; i < 13; i++)
            rCoeffs[i] = this.coeffs[i]*n;
        return new Liquide(rCoeffs);
    }

	/**
	 * prélever un montant donné et calculer le reste (si possible).
	 * @param a
	 * @return un tableau {l1,l2} tel que this = l1+l2 et l1.montant( ) = a,
	 * ou null si une telle décomposition n'est pas trouvée.
	 */
	public Liquide[] prelever(Argent a) {
		Argent zero = new Argent(0,0);
		if(a.equals(zero))
			return new Liquide[]{ new Liquide(zero), this };
		
		Liquide[] decomp = this.decomposer(a);
		Liquide lu = decomp[0];
		Liquide lp1 = decomp[1];
		Liquide lpx = decomp[2];
		Liquide lr = decomp[3];
		
		if( lp1.montant( ).equals(zero) )
			return null;
		Liquide[] s = lr.prelever(a.moins(lpx.plus(lp1).montant( )));
		if(s != null)
			return new Liquide[]{ s[0].plus(lpx).plus(lp1), s[1].plus(lu) };
		s = lr.prelever(a.moins(lpx.montant( )));
		if(s != null)
			return new Liquide[]{ s[0].plus(lpx), s[1].plus(lu).plus(lp1) };
		return null;
	}

	/**
	 * Décomposition pour prelever.
	 * @param a l'argent à décomposer.
	 * @return l tq. this equals l[0] + l[1] + l[2] + l[3],
	 *		avec
     *		l[0] = {*,...,*,*,0,...,0},
     *		l[1] = {0,...,0,1,0,...,0},
	 *		l[2] = {0,...,0,x,0,...,0},
 	 * 		l[3] = {0,...,0,0,*,...,*}
 	 * avec x maximal < coeff et (l[1]+l[2]).montant( ) <= a
	 */
	private Liquide[] decomposer(Argent a) {
		long u[] = new long[13];
		long p1[] = new long[13];
		long px[] = new long[13];
		long r[] = new long[13];
		long val = 100*a.euros( ) + a.centimes( );
		int i;
		for(i = 0; i < 13 && (VALS[i] > val || coeffs[i] == 0) ; i++)
			u[i] = coeffs[i];
		if(i < 13) {
			long q = val / VALS[i];
			long x = ( (q > coeffs[i]) ? coeffs[i] : q ) - 1;
			p1[i] = 1;
			px[i] = x ;
			r[i] = coeffs[i] - x - 1;
		}
		for(i += 1;i < 13; i++)
			r[i] = coeffs[i];
		return new Liquide[]{ new Liquide(u), new Liquide(p1), new Liquide(px), new Liquide(r) };
	}
	
}
