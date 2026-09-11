package week5.practice;
import java.util.Scanner;

public class HackathonSeatingGridOptimizer {

    static double rowAverage(int[] row) {

        int sum = 0;

        for (int i = 0; i < row.length; i++) {
            sum = sum + row[i];
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {

            double average = rowAverage(seatingScores[i]);

            if (average < threshold) {
                result = result + "Row " + i + ": Quiet Zone";
            } else {
                result = result + "Row " + i + ": Buzzing Zone";
            }

            if (i < seatingScores.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        int[][] seatingScores = new int[rows][];

        for (int i = 0; i < rows; i++) {

            System.out.print("Enter number of scores in row "
                    + i + ": ");

            int columns = scanner.nextInt();

            seatingScores[i] = new int[columns];

            System.out.println("Enter scores for row " + i + ":");

            for (int j = 0; j < columns; j++) {
                seatingScores[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();

        String result = classifyRows(seatingScores, threshold);

        System.out.println(result);

        scanner.close();
    }
}