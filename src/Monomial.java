public class Monomial implements Comparable<Monomial> {

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
