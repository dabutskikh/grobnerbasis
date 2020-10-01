public class Monomial implements Comparable<Monomial> {

    public static boolean isDivided(Monomial divident, Monomial divider) {
        for (int i = 0; i < divident.getDegrees().length; i++) {
            if (divident.getDegrees()[i] - divider.getDegrees()[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static Monomial div(Monomial divident, Monomial divider) {
        double coeff = divident.getCoeff() / divider.getCoeff();
        int[] degrees = new int[divident.getDegrees().length];
        for (int i = 0; i < degrees.length; i++) {
            degrees[i] = divident.getDegrees()[i] - divider.getDegrees()[i];
        }
        return new Monomial(coeff, degrees);
    }

    private double coeff;
    private int[] degrees;

    public Monomial(double coeff, int[] degrees) {
        this.coeff = coeff;
        this.degrees = degrees;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public int[] getDegrees() {
        return degrees;
    }

    public void setDegrees(int[] degrees) {
        this.degrees = degrees;
    }

    @Override
    public int compareTo(Monomial o) {
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] > o.degrees[i]) {
                return 1;
            } else if (degrees[i] < o.degrees[i]) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(coeff);
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] != 0) {
                stringBuilder.append("x" + (i + 1));
                if (degrees[i] != 1) {
                    stringBuilder.append("^" + degrees[i]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
