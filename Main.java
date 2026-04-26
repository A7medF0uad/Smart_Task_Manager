import java.util.Scanner; // Imports the Scanner class to read user input from the console

public class Main {

    public static void main(String[] args) {
        // Create a Scanner object to listen to the standard input stream (keyboard)
        Scanner input = new Scanner(System.in);

        // Instantiate our custom data structures
        Urgent_Task UrgentTask = new Urgent_Task();   // Uses a Stack (Array-based)
        Regular_Task RegularTask = new Regular_Task(); // Uses a Queue (Linked List-based)

        char choice = 0;
        boolean loop = true; // Control variable to keep the menu running continuously

        // Infinite loop for the console menu until the user selects '9'
        while (loop) {
            // Display the main menu options to the user
            System.out.println("Choice a Number:-");
            System.out.println("[1] Add Urgent Task       [2] Handle Urgent Task      [3] Peek Urgent");
            System.out.println("[4] Add Regular Task      [5] Process Regular Task    [6] Peek Regular ");
            System.out.println("[7] Show All Urgent       [8] Show All Regular        [9] Exit ");

            // Attempt to read the user's choice safely
            try {
                System.out.print("Your_Choice>>> ");
                // Reads the whole line, but only takes the very first character (index 0)
                choice = input.nextLine().charAt(0);
            } catch (Exception e) {
                // Catch block prevents the program from crashing if the user hits "Enter" without typing anything
                System.out.println("<Invalid_Choice>");
            }

            // Route the program flow based on the user's choice
            switch (choice) {
                case '1' -> {
                    System.out.print("Add urgent:");
                    String task = input.nextLine(); // Get the task name
                    UrgentTask.addUrgentTask(task); // Push to the Stack
                    System.out.println("[+] Urgent task added:" + task);
                }

                case '2' -> {
                    // Pop from the Stack
                    String task = UrgentTask.handleUrgentTask();
                    // Note: If the stack was empty, it prints a message but 'task' will be null. 
                    // To prevent printing "Handling:null", you could add a null check here.
                    if (task != null) {
                        System.out.println("[✓] Handling:" + task);
                    }
                }

                case '3' -> {
                    // Look at the top of the Stack without removing it
                    UrgentTask.peekNextUrgent();
                }

                case '4' -> {
                    System.out.print("Add regular:");
                    String task = input.nextLine(); // Get the task name
                    RegularTask.addRegularTask(task); // Enqueue to the Linked List
                    System.out.println("[+] Regular task added:" + task);
                }

                case '5' -> {
                    // Dequeue from the Linked List
                    String task = RegularTask.processRegularTask();
                    if (task != null) {
                        System.out.println("[✓] Processing:" + task);
                    }
                }

                case '6' -> {
                    // Look at the front of the Queue without removing it
                    RegularTask.peekNextRegular();
                }

                case '7' ->
                    // Iterate and print all tasks in the Stack
                    UrgentTask.showAllUrgent();

                case '8' ->
                    // Iterate and print all tasks in the Queue
                    RegularTask.showAllRegular();

                case '9' -> {
                    // Exit the program by breaking the while loop condition
                    System.out.println("<See_U_Soon>");
                    loop = false;
                }

                default ->
                    // Fallback for any character that isn't 1 through 9
                    System.out.println("<Try_Again>");
            }
        }
    }
}
