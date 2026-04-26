// ---------------------------------------------------------
// This class acts as a Node for a Singly Linked List.
// ---------------------------------------------------------
class Task {

<<<<<<< HEAD
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
=======
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
public class Regular_Task {

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
