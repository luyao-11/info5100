import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //  user enter the total number of their assignments
        System.out.println(" Please enter the total number of assignments greater than 0: ");
        Scanner input1 = new Scanner(System.in);
        int totalAssignments = input1.nextInt();
        System.out.println();


        //  users  enter the total points of each assignment
        double[] pointsTotal = new double[totalAssignments];
        for (int i=0; i<totalAssignments;i++) {
            System.out.printf (" Please enter the total points of each assignment %d\n", i+1);
            Scanner input2 =new Scanner(System.in);
            double pointTotal = input2.nextDouble();
            pointsTotal[i] =pointTotal;
        }
        System.out.println();

        // users  enter weight of each assignment
        double[] assignmentPercentages = new double[totalAssignments];
        double percentage = 0;
        for (int i=0; i<totalAssignments;i++) {
            System.out.printf (" Please enter the weight of each assignment %d\n", i+1);
            Scanner input3 =new Scanner(System.in);
            double assignmentPercentage = input3.nextDouble();
            assignmentPercentages[i] = assignmentPercentage;
        //calculate the total weight
            percentage+=assignmentPercentage;
        }
        System.out.println();


        // total assignment percentage should be 100, if not equal to 100 should be returned
        if (percentage == 100) {
            double finalGrade = 0;
        //users enter grade of each assignment
            double[] studentsGrades = new double[totalAssignments];
            for(int i = 0; i < totalAssignments; i++) {
                System.out.printf("Please enter the grade of each assignment %d\n", i+1);
                Scanner input4 = new Scanner(System.in);
                double studentGrade = input4.nextDouble();

                finalGrade +=studentGrade / pointsTotal[i] * assignmentPercentages[i];
                studentsGrades[i] = studentGrade;
            }
            System.out.println();
            System.out.println("The final grade is " + finalGrade);
        }
        else
            System.out.println(" total weight is not equal to 100, please try again");
    }
}











