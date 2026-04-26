// ---------------------------------------------------------
// This class implements a Stack (LIFO - Last In, First Out) 
// using a fixed-size Array.
// ---------------------------------------------------------
public class Urgent_Task {

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

