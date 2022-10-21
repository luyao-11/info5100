package lab4;

import java.util.ArrayList;

public class WeightGradeCal {


    private ArrayList<Double> pointTotal;
    private ArrayList<Double> earnedPoints;
    private ArrayList<Double> assignmentPercentage;
    private double weightGrades;


    //getter and setter method
    public ArrayList<Double> getPointTotal() {return pointTotal;}
    public void setPointTotal(ArrayList<Double> pointTotal) {this.pointTotal = pointTotal;}

    public ArrayList<Double> getEarnedPoints() {return earnedPoints;}
    public void setEarnedPoints(ArrayList<Double> earnedPoints) {this.earnedPoints = earnedPoints;}

    public ArrayList<Double> getAssignmentPercentage() {return assignmentPercentage;}
    public void setAssignmentPercentage(ArrayList<Double> assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;}

    public double getWeightGrades() {return weightGrades;}
    public void setWeightGrades(double weightGrades) {this.weightGrades = weightGrades;}


    //Calculating average grades
    public void calculation() {
        double sum=0;
        for (int i = 0; i< pointTotal.size(); i++){
            sum += this.earnedPoints.get(i) / this.pointTotal.get(i) * this.assignmentPercentage.get(i);
        }
        this.weightGrades =sum;
    }
}

