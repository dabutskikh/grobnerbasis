public class GrobnerBasis {

    public static boolean isDivided(Polynomial h, Polynomial f) {
        Monomial ltH = h.getLeadingTerm();
        Monomial ltF = f.getLeadingTerm();
        for (int i = 0; i < ltH.getDegrees().length; i++) {
            if (ltH.getDegrees()[i] - ltF.getDegrees()[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
