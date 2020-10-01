public class GrobnerBasis {

    public static Polynomial reduce(Polynomial h, Polynomial f, Polynomial q) {
        return Polynomial.sub(h, Polynomial.mul(q, f));
    }

    public static boolean isBelongsBasis(Polynomial h, Polynomial[] basis) {
        Monomial ltH = h.getLeadingTerm();
        for (Polynomial f : basis) {
            Monomial ltF = f.getLeadingTerm();
            if (Monomial.isDivided(ltH, ltF)) {
                Polynomial q = new Polynomial(Monomial.div(ltH, ltF));
                Polynomial h1 = reduce(h, f, q);
                if (h1.getMonomials().size() == 0) {
                    return true;
                } else {
                    return isBelongsBasis(h1, basis);
                }
            }
        }
        return false;
    }
}
