import java.util.Scanner;
public class Interpolador {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double x0 = 0, x1 = 0.5, x2 = 1;
        double y0, y1, y2;

        System.out.print("X: ");
        double xValue = sc.nextDouble();

        y0 = funcao(x0);
        y1 = funcao(x1);
        y2 = funcao(x2);

        double result = lagrange (x0, x1, x2, y0, y1, y2, xValue);

        System.out.println("Para valor " + xValue + " o valor interpolado é " + result);
        sc.close();
    }

    public static double funcao (double ponto) {
        double e =  2.71828;
        double result = Math.pow(e,2*ponto);
        return result;
    }

    public static double lagrange (double x0, double x1, double x2, double y0, double y1, double y2, double x) {
        double l0 = ((x - x1) * (x - x2)/(x0 - x1) * (x0 - x2));
        double l1 = ((x - x0) * (x - x2))/((x1 - x0) * (x1 - x2));
        double l2 = ((x - x0) * (x - x1))/((x2 - x0) * (x2 - x1));
        return y0 * l0 + y1 * l1 + y2 * l2;
    }
}
