package com.chrisstubbs;

class Test {
    private String firstName;
    private String lastName;
    private int[] testScores;

    private Test(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        testScores = new int[5];
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private Test() {
        this("John", "Doe");
        testScores = new int[5];
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    int[] getTestScores() {
        return testScores;
    }

    static double average(int[] testScores) {
        int avg = 0;
        for (int testScore : testScores) {
            avg = avg + testScore;
        }

        avg /= testScores.length;
        return avg;
    }

    static Test newTests() {
        return new Test();
    }
}
