public class Main {

    public static void main(String[] args) {
        Polynomial polynomial = new Polynomial(
                new Monomial(4, new int[] {1, 2, 0, 4}),
                new Monomial(2, new int[] {0, 2, 0, 3}),
                new Monomial(3, new int[] {0, 2, 2, 4}),
                new Monomial(-1, new int[] {0, 0, 1, 4})
        );
        System.out.println(polynomial);
    }
}
