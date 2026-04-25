
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

// ---------------------------------------------------------
// This class implements a Stack (LIFO - Last In, First Out) 
// using a fixed-size Array.
// ---------------------------------------------------------
class Urgent_Task {

    // Fixed capacity of 20 tasks
    String tasks[] = new String[20];

    // 'top' tracks the index of the most recently added item. 
    // -1 means the array is currently empty.
    private int top = -1;

    // Helper method to check if the stack is empty
    public boolean isUrgentEmpty() {
        return this.top == -1;
    }

    // Helper method to check if the stack is full (index 19 is the max for an array of size 20)
    public boolean isUrgentFull() {
        return this.top == tasks.length - 1;
    }

    // Push operation: Adds an item to the top of the stack
    public void addUrgentTask(String task) {
        if (isUrgentFull()) {
            System.out.println("<Stack_Full>");
        } else {
            this.top += 1;             // Move the pointer up
            this.tasks[this.top] = task; // Insert the task at the new top index
        }
    }

    // Pop operation: Removes and returns the item from the top of the stack
    public String handleUrgentTask() {
        if (isUrgentEmpty()) {
            System.out.println("No_urgent_tasks<!>");
        } else {
            int task = this.top; // Store the current top index
            this.top -= 1;       // Move the pointer down (effectively deleting the top item)
            return this.tasks[task]; // Return the stored task
        }
        return null;
    }

    // Peek operation: Looks at the top item without removing it
    public void peekNextUrgent() {
        if (isUrgentEmpty()) {
            System.out.println("No_urgent_tasks<!>");
        } else {
            System.out.println("[+] the Current Urgent task:" + this.tasks[this.top]);
        }
    }

    // Display operation: Prints all items from top to bottom (LIFO order)
    public void showAllUrgent() {
        if (isUrgentEmpty()) {
            System.out.println("No_urgent_tasks<!>");
        } else {
            // Loop backwards from the top index down to 0
            for (int i = this.top; i >= 0; i--) {
                System.out.println("Urgent_Task:" + this.tasks[i]);
            }
        }
    }
}

// ---------------------------------------------------------
// This class acts as a Node for a Singly Linked List.
// ---------------------------------------------------------
class Task {

    String taskName; // The data payload
    Task next = null; // Pointer to the next node in the chain

    // Constructor to easily create a new node
    public Task(String task) {
        this.taskName = task;
    }
}

// ---------------------------------------------------------
// This class implements a Queue (FIFO - First In, First Out)
// using a Singly Linked List.
// ---------------------------------------------------------
class Regular_Task {

    // 'front' points to the first node (the next one to be processed)
    private Task front;
    // 'rear' points to the last node (where new tasks are added)
    private Task rear;
    // Keeps track of how many items are currently in the queue
    private int Totalsize;

    // Constructor initializes an empty queue
    public Regular_Task() {
        this.front = this.rear = null;
        this.Totalsize = 0;
    }

    // Helper method to check if the queue is empty
    public boolean isRegularEmpty() {
        return this.front == null;
    }

    // Enqueue operation: Adds an item to the back (rear) of the queue
    public void addRegularTask(String task) {
        Task newTask = new Task(task); // Create the new list node

        if (isRegularEmpty()) {
            // If it's the first item, both front and rear point to it
            this.front = this.rear = newTask;
        } else {
            // Link the old last node to the new node
            this.rear.next = newTask;
            // Update the rear pointer to be the new node
            this.rear = newTask;
        }
        this.Totalsize++; // Increment task counter
    }

    // Dequeue operation: Removes and returns the item from the front of the queue
    public String processRegularTask() {
        if (isRegularEmpty()) {
            System.out.println("<There_No_Regular_Task>");
        } else {
            // Store the data of the front node
            String task = this.front.taskName;
            // Move the front pointer to the next node (effectively deleting the old front)
            this.front = this.front.next;
            this.Totalsize--; // Decrement task counter
            return task;
        }
        // Note: this.Totalsize--; was originally misplaced in your code outside the 'else' block, 
        // which could cause it to decrement when empty. It is fixed by placing it inside the else block above, 
        // or leaving it where it was logically safely since it returns before reaching it.
        return null;
    }

    // Peek operation: Looks at the front item without removing it
    public void peekNextRegular() {
        if (isRegularEmpty()) {
            System.out.println("<There_No_Regular_Task>");
        } else {
            System.out.println("[+] the Current Regular task:" + this.front.taskName);
        }
    }

    // Display operation: Prints all items from front to back (FIFO order)
    public void showAllRegular() {
        Task temp = this.front; // Start at the front of the list

        if (isRegularEmpty()) {
            System.out.println("<There_No_Regular_Task>");
        } else {
            // Traverse the linked list following the 'next' pointers
            for (int i = 0; i <= this.Totalsize - 1; i++) {
                System.out.println("Regular_Task(" + (i + 1) + "):" + temp.taskName);
                temp = temp.next; // Move to the next node
            }
        }
    }
}
