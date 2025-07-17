import java.util.Scanner;

public class FinancialForecasting {

    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.05 for 5%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = sc.nextInt();

        double futureValue = predictFutureValue(currentValue, growthRate, years);
        System.out.printf("Predicted future value after %d years: %.2f\n", years, futureValue);

        sc.close();
    }
}
