package week5.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public Candidate(String name, double cgpa, int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only eligibility check
    static boolean isEligible(double cgpa) {

        return cgpa >= 7.5;
    }

    // Combined CGPA and coding score eligibility check
    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && cgpa < 7.5 && codingScore >= 60;
    }

    // Composite score
    private double getCompositeScore() {

        return (cgpa * 10) + codingScore;
    }

    // Ranking logic
    @Override
    public int compareTo(Candidate other) {

        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];

        int count = 0;

        for (Candidate candidate : candidates) {

            if (isEligible(candidate.cgpa)
                    || isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted[count] = candidate;
                count++;
            }
        }

        // Create array containing only shortlisted candidates
        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

        // Java sorts using compareTo()
        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + finalList[i].name
                    + " ("
                    + finalList[i].getCompositeScore()
                    + ")";

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = scanner.nextInt();

        scanner.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Candidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = scanner.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = scanner.nextInt();

            scanner.nextLine();

            candidates[i] =
                    new Candidate(name, cgpa, codingScore);
        }

        String result = shortlistAndRank(candidates);

        System.out.println("\nShortlisted Candidates:");
        System.out.println(result);

        scanner.close();
    }
}