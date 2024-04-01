public class GaussJacobi {
    public static void main(String[] args) {
        // Definir matriz de coeficientes e vetor de termos independentes
        double[][] matrix = {
            {5, 1, 1, 5},
            {3, 4, 1, 6},
            {3, 3, 6, 0}
        };

        // Definir critérios de convergência
        double epsilon = 0.0001;
        int maxIterations = 1000;

        // Resolver sistema de equações
        double[] solution = gaussJacobi(matrix, epsilon, maxIterations);

        // Imprimir solução
        System.out.println("Solução encontrada:");
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x[" + i + "] = " + solution[i]);
        }
    }

    public static double[] gaussJacobi(double[][] matrix, double epsilon, int maxIterations) {
        int n = matrix.length;
        double[] x = new double[n]; // valores iniciais de x
        double[] xOld = new double[n]; // valores antigos de x

        // Iterações
        int iterations = 0;
        while (iterations < maxIterations) {
            // Atualizar valores de x
            for (int i = 0; i < n; i++) {
                double sum = matrix[i][n]; // termo independente
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= matrix[i][j] * xOld[j];
                    }
                }
                x[i] = sum / matrix[i][i];
            }

            // Verificar convergência
            double error = 0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(x[i] - xOld[i]);
            }
            if (error < epsilon) {
                break; // convergido
            }

            // Atualizar valores de xOld
            System.arraycopy(x, 0, xOld, 0, n);

            iterations++;
        }

        return x;
    }
}
