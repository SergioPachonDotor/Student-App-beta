import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Sergio Pachón D.
 */

public class Student {

    private String student_name;
    private Integer student_level;

    private static Map<String, Map<String, Integer>> period_results = new HashMap<String, Map<String, Integer>>();

    public static String[] assignments = {"Assignment 1", "Assignment 2"};
    public static String[] courses = {"Mathematics", "English", "Sciences", "Computer Science", "Sports"};

    public static Scanner input_command = new Scanner(System.in);

    private Map<String,Map<String,Integer>> sorted_scores;


    public Student(String name, Integer level){
        
        student_name = name;
        student_level = level;
        }

    public void Create_Student(){

        System.out.println("\nRecord Student Name: ");
        String name =  input_command.nextLine();
        this.student_name = name;

        System.out.println("\nRecord Student Level (1 - 11): ");
        Integer level = input_command.nextInt();
        this.student_level = level;
    }

    public void Register_Period_Scores(){

        System.out.println("__________\n\nRecord Student Scores\n__________\n");

        for (int course_name = 0; course_name < courses.length; course_name++){
            
            System.out.println("__________\n\n" + courses[course_name] + "\n__________\n");
            Map<String, Integer> period_scores = new HashMap<String, Integer>();

            for (int k = 0; k < assignments.length; k++){
                System.out.println("Enter Score For: " + assignments[k]);
                Integer score = input_command.nextInt();
                if (score <= 100){
                    period_scores.put(assignments[k], score); 
                }
                else{
                    System.out.println("Score Must Be Between (0 - 100)");
                    break;
                }

            period_results.put(courses[course_name], period_scores);
            }
        }
        this.sorted_scores = period_results;
    }

    public void Show_Student(){
        System.out.println("\n");
        if (student_name != "None"){
            System.out.println("Student Name: "+ student_name);
        }
        
        if (student_level >= 4){
            System.out.println("Student Level: "+ student_level + "th Grade");
    }
        else if (student_level == 1){
            System.out.println("Student Level: "+ student_level + "st Grade");
        }
        else if (student_level == 2){
            System.out.println("Student Level: "+ student_level + "nd Grade");
        }
        else if (student_level == 3){
            System.out.println("Student Level: "+ student_level + "rd Grade");
        }
        System.out.println("\n");
    }

    public void Show_Student_Scores(){

        if (sorted_scores != null){
            for (Map.Entry<String,Map<String,Integer>> courses : sorted_scores.entrySet()) {
                String course = courses.getKey();
                Map<String,Integer> value = courses.getValue();
                System.out.println("\n_____");
                System.out.println(course + " Scores: ");
    
                for (Map.Entry<String,Integer> assignments_to_show : value.entrySet()){
                    String assignment = assignments_to_show.getKey();
                    Integer assignment_score = assignments_to_show.getValue();
                    System.out.println("    -> " + assignment + " : " + assignment_score);
                }
            }
        }

        else{
            System.out.println("Oops! There are no scores to show.");
        }
    }

    public void Show_Final_Score(){

        if (sorted_scores != null){

            float scores_sum = 0.0f;
            for (Map.Entry<String,Map<String,Integer>> courses : sorted_scores.entrySet()) {
                
                String course = courses.getKey();
                Map<String,Integer> value = courses.getValue();
                scores_sum = 0.0f;
    
                for (Map.Entry<String,Integer> assignments_to_calculate : value.entrySet()){
                    Integer assignment_score = assignments_to_calculate.getValue();
                    float float_assignment_score = assignment_score.floatValue();
                    scores_sum += float_assignment_score;
                }
                System.out.println("\n_____");
                System.out.println(course + " Final Score: ");
                System.out.println("    -> " + scores_sum/assignments.length);
            }
            
        }

        else{
            System.out.println("Oops! There are no scores to show.");
        }
    }
}
    // public static void main(String[] args) {
    //     Student student = new Student("Sergio Pachón", 11);
    //     student.Show_Student();
    //     student.Register_Period_Scores();
    //     student.Show_Student_Scores();
    //     student.Show_Final_Score();
    // }