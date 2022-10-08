package StudentGradeLevel;
// Importing Classes
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//This program assumes that the student has 8 grades,so create the array of size 8
        WeightGradeCal grade = new WeightGradeCal();
        Scanner myScanner = new Scanner(System.in);
        double[] pointTotal =new double[8];
        double[] earnedPoints=new double[8];
        double[] assignmentPercentage =new double[8];


// student is supposed to enter their data. When 8 grades are entered, the "for" can be executed
        System.out.println("Enter your 8 total points, separated by a space");
        for (int i = 0; i<8; i++) {
            pointTotal[i] = myScanner.nextDouble();
        }
        grade.setPointTotal(pointTotal);

        System.out.println("Enter your 8 assignment percentages, separated by a space ");
        for (int i = 0; i<8; i++) {
            assignmentPercentage[i] = myScanner.nextDouble();
        }
        grade.setAssignmentPercentage(assignmentPercentage);

        System.out.println("Enter your 8 earned points, separated by a space");
        for (int i=0; i<8; i++) {
            earnedPoints[i] = myScanner.nextDouble();
        }
        grade.setEarnedPoints(earnedPoints);



        //calculate and then print the final grade

        System.out.println("Your final grade is:");

        grade.calculation();

        System.out.println(grade.getWeightGrades());



        //checking whether the grade satisfy the grade level and print out

        System.out.println("Your final grade level is:");

        if (grade.getWeightGrades()>=90) {
            System.out.println("A");
        } else if(grade.getWeightGrades()>=80 && grade.getWeightGrades()<89.999) {
            System.out.println("B");
        } else if(grade.getWeightGrades()>=70 && grade.getWeightGrades()<80) {
            System.out.println("C");
        } else if(grade.getWeightGrades()>=60 && grade.getWeightGrades()<70) {
            System.out.println("D");
        } else
            System.out.println("F");

    }
}