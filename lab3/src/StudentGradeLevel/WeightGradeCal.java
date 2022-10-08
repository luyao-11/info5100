package StudentGradeLevel;

public class WeightGradeCal {
    //The class declare  private variables,
    //Since they are private, the code from the outside of this class cannot access the variables directly,
    //in order to read and update the variable, use getter and setter
    private double[]pointTotal;
    private double[] earnedPoints;
    private double[] assignmentPercentage;
    private double weightGrades;


//setter is to update data and getter retrieve data so that the outside of this class can read the value of the variable

    public double[] getPointTotal() {return pointTotal;}
    public void setPointTotal(double[] pointTotal) { this.pointTotal = pointTotal;}


    public double[] getEarnedPoints() {return earnedPoints;}
    public void setEarnedPoints(double[] earnedPoints) {this.earnedPoints = earnedPoints;}


    public double[] getAssignmentPercentage() {return assignmentPercentage;}
    public void setAssignmentPercentage(double[] assignmentPercentage) {this.assignmentPercentage = assignmentPercentage;}

    public double getWeightGrades() {return weightGrades;}
    public void setWeightGrades(double weightGrades) {this.weightGrades = weightGrades;}


    //Calculating average grades
    public void calculation(){
        double sum=0;
        for (int i = 0; i<8; i++){
            sum += this.earnedPoints[i] / this.pointTotal[i] * this.assignmentPercentage[i];
        }
        this.weightGrades =sum;
    }


}
