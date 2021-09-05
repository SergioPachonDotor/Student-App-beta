import java.util.Scanner;

/**
 *
 * @author Sergio Pachón D.
 */

public class App {

    public static Scanner input_command = new Scanner(System.in);
    Student student = new Student("None", 0);
    

    public static void greet_user() {

        String greets = "\nWelcome to Scores Database\n";
        String[] options = { "Record Grades", "Show Grades", "Show Definitive", "Salir" };

        System.out.println(greets);
        for (int i = 0; i < options.length; i++) {
            int index = i + 1;
            System.out.println("[" + index + "] " + options[i]);
        }
        System.out.println("\n");
    }

    public void menu() {
        
              
        Boolean flag = true;
        
        while (flag == true) {
            greet_user();  
            System.out.println("Choose What You Want To Do: ");
            Integer command = input_command.nextInt();
            if (command == 1) {
                student.Create_Student();
                student.Show_Student();
                student.Register_Period_Scores();
            }

            else if (command == 2) {
                student.Show_Student();
                student.Show_Student_Scores();
            }

            else if (command == 3) {
                student.Show_Student();
                student.Show_Final_Score();
            }

            else if (command == 4) {
                System.out.println("Goodbye!");
                flag = false;
                break;
            }

            else {
                System.out.println("Invalid Command");
                flag = false;
                break;
            }
        }

    }

    public static void main(String[] args) {
        App app = new App();
        app.menu();
    }
}