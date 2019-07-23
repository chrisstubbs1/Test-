package com.chrisstubbs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of students");
        int size = scan.nextInt();
        Test[] tests = new Test[size];
        scan.nextLine();

        populateTestArr(tests);
        printGrades(tests);
        new MainWindow();
    }

    private static void populateTestArr(Test[] test) {
        for (int i = 0; i < test.length; i++) {
            test[i] = Test.newTests();
            System.out.println("Enter student " + (i + 1) + " first name");
            String firstName = scan.nextLine();
            test[i].setFirstName(firstName);

            System.out.println("Enter student " + (i + 1) + " last name");
            String lastName = scan.nextLine();
            test[i].setLastName(lastName);

            for (int j = 0; j < 5; j++) {
                System.out.println("Enter test score " + (j + 1));
                int score = scan.nextInt();
                test[i].getTestScores()[j] = score;
            }

            scan.nextLine();
        }

        scan.close();
    }

    private static void printGrades(Test[] testArr) {
        double classAverage = calculateClassAverage(testArr);

        System.out.println("First name\tLast name\tT1\tT2\tT3\tT4\tT5\tAvg\tGrade");
        System.out.println("=====================================================");

        for (Test test : testArr) {
            System.out.println(test.getFirstName() + "\t" + test.getLastName() + "\t" + test.getTestScores()[0]
                    + "\t" + test.getTestScores()[1] + "\t" + test.getTestScores()[2] + "\t" + test.getTestScores()[3] + "\t"
                    + test.getTestScores()[4] + "\t" + Test.average(test.getTestScores()) + "\t" + letterGrade(testArr));
        }

        System.out.println();
        System.out.println("Class Average: " + classAverage);
    }

    private static double calculateClassAverage(Test[] testArr) {
        double classAverage = 0;

        for (Test test : testArr) {
            classAverage += Test.average(test.getTestScores());
        }

        return classAverage / testArr.length;
    }

    private static char letterGrade(Test[] testArr) {
        char grade = 'F';
        int sum = 0;

        for (Test test : testArr) {
            sum += Test.average(test.getTestScores());

            if (sum <= 100 && sum > 90) {
                grade = 'A';
            } else if (sum <= 89 && sum >= 80) {
                grade = 'B';
            } else if (sum <= 79 && sum >= 70) {
                grade = 'C';
            } else if (sum <= 69 && sum >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
        }
        return grade;
    }
}
