import java.util.Arrays;
import java.util.Collections;

public class Polynomial {

    private Monomial[] monomials;

    public Polynomial(Monomial... monomials) {
        Arrays.sort(monomials, Collections.reverseOrder());
        this.monomials = monomials;
    }

    public Monomial[] getMonomials() {
        return monomials;
    }

    public void setMonomials(Monomial[] monomials) {
        this.monomials = monomials;
    }

    public Monomial getLeadingTerm() {
        return monomials[0];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(monomials[0].toString());
        for (int i = 1; i < monomials.length; i++) {
            if (monomials[i].getCoeff() > 0) {
                stringBuilder.append("+");
            }
            stringBuilder.append(monomials[i].toString());
        }
        return stringBuilder.toString();
    }
}
