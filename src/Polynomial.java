import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Polynomial {

    public static Polynomial mul(Polynomial p1, Polynomial p2) {
        List<Monomial> res = new ArrayList<>();
        for (Monomial m1 : p1.getMonomials()) {
            for (Monomial m2 : p2.getMonomials()) {
                double coeff = m1.getCoeff() * m2.getCoeff();
                int[] degrees = new int[m2.getDegrees().length];
                for (int i = 0; i < degrees.length; i++) {
                    degrees[i] = m1.getDegrees()[i] + m2.getDegrees()[i];
                }
                res.add(new Monomial(coeff, degrees));
            }
        }
        return new Polynomial(res);
    }

    public static Polynomial sub(Polynomial p1, Polynomial p2) {
        List<Monomial> res = new ArrayList<>();
        for (Monomial m1 : p1.getMonomials()) {
            res.add(m1);
        }
        for (Monomial m2 : p2.getMonomials()) {
            res.add(new Monomial(-1 * m2.getCoeff(), m2.getDegrees()));
        }
        return new Polynomial(res);
    }

//    public static Polynomial add(Polynomial p1, Polynomial p2) {
//        List<Monomial> res = new ArrayList<>();
//        for (Monomial m1 : p1.getMonomials()) {
//            res.add(m1);
//        }
//        for (Monomial m2 : p2.getMonomials()) {
//            res.add(m2);
//        }
//        return new Polynomial(res);
//    }

    private List<Monomial> monomials;

    public Polynomial(List<Monomial> monomials) {
        Collections.sort(monomials, Collections.reverseOrder());
        for (int i = monomials.size() - 1; i >= 1; i--) {
            if (monomials.get(i).compareTo(monomials.get(i - 1)) == 0) {
                monomials.get(i - 1).setCoeff(
                        monomials.get(i - 1).getCoeff()
                        + monomials.get(i).getCoeff()
                );
                monomials.remove(i);
            }
        }
        for (int i = monomials.size() - 1; i >= 0; i--) {
            if (monomials.get(i).getCoeff() == 0) {
                monomials.remove(i);
            }
        }
        this.monomials = monomials;
    }

    public Polynomial(Monomial... monomials) {
        this(new ArrayList<>(Arrays.asList(monomials)));
    }

    public List<Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(List<Monomial> monomials) {
        this.monomials = monomials;
    }

    public Monomial getLeadingTerm() {
        return monomials.get(0);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (monomials.size() != 0) {
            stringBuilder.append(monomials.get(0).toString());
            for (int i = 1; i < monomials.size(); i++) {
                if (monomials.get(i).getCoeff() > 0) {
                    stringBuilder.append("+");
                }
                stringBuilder.append(monomials.get(i).toString());
            }
        } else {
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }
}
