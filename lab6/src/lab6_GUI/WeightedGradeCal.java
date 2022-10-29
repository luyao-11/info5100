package lab6_GUI;
import java.util.Scanner;
public class WeightedGradeCal {
    private double pointTotal;
    private double earnedPoints;
    private double assignmentPercentage;
    private double totalWeightedGrade;

    //constructor to specify the initial state
    public WeightedGradeCal(double pointTotal, double earnedPoints, double assignmentPercentage) {
        this.pointTotal = pointTotal;
        this.earnedPoints = earnedPoints;
        this.assignmentPercentage = assignmentPercentage;
    }



    //return the value of private variables
    public double getPointTotal() {return pointTotal;}

    public double getEarnedPoints() {return earnedPoints;}

    public double getAssignmentPercentage() {return assignmentPercentage;}

    public double getTotalWeightedGrade() {return totalWeightedGrade;}

    //create method to calculate grade
    public double calculation() {
        totalWeightedGrade = earnedPoints / pointTotal * assignmentPercentage * 100;
        return totalWeightedGrade;
    }

    // user enter their data
    public static void main(String[] args) {

        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter your total point: ");
        double pointTotal = input1.nextDouble();

        System.out.println("iPlease enter your earned points:");
        double earnedPoints = input1.nextDouble();

        System.out.println("Please enter your assignment percentage:");
        double assignmentPercentage = input1.nextDouble();

    // create object and call method
        WeightedGradeCal grade = new WeightedGradeCal(pointTotal, earnedPoints, assignmentPercentage);
        double result = grade.calculation();
        System.out.println("Your total weighted grade is:" + result);
    }
}
