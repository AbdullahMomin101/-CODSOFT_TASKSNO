import java.util.Scanner;

public class StudentGradeCalculator {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subject: ");
        int subjectCount = scanner.nextInt();

        if(subjectCount <= 0){
            System.out.println("The number of subjects must be greater than 0 ");
            scanner.close();
            return;
        }
        int totalMarks = 0;
        for (int i = 1; i <= subjectCount; i++){
            System.out.println("Enter marks for subject" + i + "(0 - 100)");
            int marks = scanner.nextInt();

            if (marks <0 || marks > 100){
                System.out.println("marks must be between 0 and 100. Please try again.");
                i--;
                continue;
            }
            totalMarks += marks;
        }
        double average = (double) totalMarks / subjectCount;
        char grade;

        if (average >= 90){
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        }else if (average >= 60){
            grade = 'D';
        }else grade = 'F';

        System.out.println("\nTotal marks: " + totalMarks + " / " + (subjectCount * 100));
        System.out.printf("Average: %.2f%%%n",average);
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
