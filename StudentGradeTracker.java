package StudentGradeTracker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");
        System.out.println("Please enter the students' grades below.");
        System.out.println("To finish entering grades, type -1.");
        System.out.println("Note: Grades should be between 0 and 100.\n");

        while (true) {
            try {
                System.out.print("Enter grade: ");
                double grade = scanner.nextDouble();

                // Terminate input if the user enters -1
                if (grade == -1) {
                    break;
                }

                // Validate the input
                if (grade < 0 || grade > 100) {
                    System.out.println("Error: Grade must be between 0 and 100. Please try again.");
                } else {
                    grades.add(grade);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric grade.");
                scanner.next(); // Clear the invalid input
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades were entered. Program terminated.");
        } else {
            double sum = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double grade : grades) {
                sum += grade;

                if (grade > highest) {
                    highest = grade;
                }

                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = sum / grades.size();

            System.out.println("\n=== Grade Summary ===");
            System.out.printf("Total number of grades entered: %d%n", grades.size());
            System.out.printf("Average grade: %.2f%n", average);
            System.out.printf("Highest grade: %.2f%n", highest);
            System.out.printf("Lowest grade: %.2f%n", lowest);
            System.out.println("=== End of Summary ===");
        }

        scanner.close();
    }
}
