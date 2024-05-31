import java.util.Scanner;
import java.util.ArrayList;

public class todo {
    
     public static void clearScreen(){
         System.out.print("\033[H\033[2J");
         System.out.flush();
     }

    public static void printTask(ArrayList<String> task) {
        if (task.isEmpty()) {
            System.out.println("No Tasks yet.....");
        } else {
            System.out.printf("--------------------%n");
            System.out.printf("|%-18s|%n","Tasks");
            System.out.printf("--------------------%n");
            for (int i = 0; i < task.size(); i++) {
                System.out.printf("|%-2d|%-15s|%n", (i + 1), task.get(i));
                System.out.println();
                
            }
        }
    }

    public static void addTask(ArrayList<String> task, Scanner scan) {
        System.out.print("\nEnter Task to add:");
        scan.nextLine();
        String newTask = scan.nextLine();
        task.add(newTask);
        System.out.println("Task added.");
        clearScreen();
    }

    public static void deleteTask(ArrayList<String> task, Scanner scan) {
        if (task.isEmpty()) {
            System.out.println("No Tasks To Remove...");
        } else {
            System.out.print("Enter the task number to remove:");
            int taskNumber = scan.nextInt() - 1;
            if (taskNumber >= 0 && taskNumber < task.size()) {
                task.remove(taskNumber);
                System.out.println("Task Removed.");
                clearScreen();

            } else {
                System.out.println("Invalid Task Number....");
            }
        
        }
        
    }

    public static void markTaskDone(ArrayList<String> task, Scanner scan) {
        if (task.isEmpty()) {
            System.out.println("No tasks to mark as done.");
        } else {
            System.out.print("Enter Task Number To Mark As Done:");
            int taskDone = scan.nextInt() - 1;
            if (taskDone >= 0 && taskDone < task.size()) {
                task.set(taskDone, "✓ " + task.get(taskDone));
                System.out.println("Task Marked As Done.");
                clearScreen();
            } else {
                System.out.println("Invalid Task Number.....");
            }
        }
    }

    public static void displayMenu(ArrayList<String> task) {
        System.out.printf("--------------------%n");
        System.out.printf("|%-18s|%n","To-Do List");
        System.out.printf("--------------------%n");
        System.out.printf("|%-2d|%-15s|%n",1," Add Task");
        System.out.printf("|%-2d|%-15s|%n",2," Mark Task Done");
        System.out.printf("|%-2d|%-15s|%n",3," Delete Task");
        System.out.printf("|%-2d|%-15s|%n",4," Print Task");
        System.out.printf("|%-2d|%-15s|%n",5," Exit");
        System.out.printf("--------------------%n");
        System.out.println("");
        System.out.print("Enter the choice:");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> task = new ArrayList<>();
        int choice;
        while (true) {
            // Main loop continues until user exits
            displayMenu(task);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    addTask(task, scan);
                    break;
                case 2:
                    markTaskDone(task, scan);
                    break;
                case 3:
                    deleteTask(task, scan);
                    break;
                case 4 :
                    printTask(task);
                    break;
                case 5:
                    System.out.println("Exiting.....");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
