package lab4;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // a Scanner class for inputting
        Scanner sc = new Scanner (System.in);
        // an object to get the final result
        WeightGradeCal grade = new WeightGradeCal();
        // new arraylist for pointTotal, earnedPoints, assignmentPercentage
        ArrayList<Double> pointTotal = new ArrayList<>();
        ArrayList<Double> earnedPoints = new ArrayList<>();
        ArrayList<Double> assignmentPercentage = new ArrayList<>();

        //user can vary the number of assignments
        //the while Loop through a block of code as long as the user enter 0.0
        boolean end = false;
        while (!end) {
            System.out.println("please enter your total points for each assignment  and 0.0 for exit");
            Double a = sc.nextDouble();
            if (!a.equals(0.0)) {
                pointTotal.add(a);
            } else {
                end = true;
            }
        }
        grade.setPointTotal(pointTotal);

        //the user enter the percentage of each assignment
        for (int i = 0; i < pointTotal.size(); i++) {
            System.out.println("please enter weighted percentage for each assignment");
            assignmentPercentage.add(sc.nextDouble());
        }
        grade.setAssignmentPercentage(assignmentPercentage);

        //the user enter the percentage of each earned points
        for (int i = 0; i < pointTotal.size(); i++) {
            System.out.println("please enter your earned points for each assignment");
            earnedPoints.add(sc.nextDouble());
        }
        grade.setEarnedPoints(earnedPoints);


        //calculate and then print the final grade
        System.out.println("Your final grade is:");
        grade.calculation();
        System.out.println(grade.getWeightGrades());


        //get the grade level and print out
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