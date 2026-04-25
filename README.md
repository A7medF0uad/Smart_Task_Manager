# Task Management System (Java)

A console-based application that demonstrates the implementation of fundamental data structures—**Stacks** and **Queues**—to manage two different types of tasks: **Urgent** and **Regular**.

## 🚀 Overview

The system categorizes tasks into two streams:
1.  **Urgent Tasks**: Managed using a **Stack** (Array-based). This follows the **LIFO** (Last-In-First-Out) principle, where the most recently added urgent task is handled first.
2.  **Regular Tasks**: Managed using a **Queue** (Linked List-based). This follows the **FIFO** (First-In-First-Out) principle, ensuring tasks are processed in the order they were received.

---

## 🛠️ Data Structures Implemented

### 1. Urgent Task Manager (Stack)
The `Urgent_Task` class uses a fixed-size array to store strings.
- **Mechanism**: Last-In-First-Out (LIFO).
- **Storage**: `String tasks[] = new String[20]`.
- **Key Methods**:
    - `addUrgentTask(task)`: Pushes a task onto the stack.
    - `handleUrgentTask()`: Pops the most recent task from the stack.
    - `peekNextUrgent()`: Views the top task without removing it.

### 2. Regular Task Manager (Queue)
The `Regular_Task` class is implemented using a custom Singly Linked List.
- **Mechanism**: First-In-First-Out (FIFO).
- **Node Structure**: A helper `Task` class defines the data (`taskName`) and the pointer (`next`).
- **Key Methods**:
    - `addRegularTask(task)`: Enqueues a task at the rear.
    - `processRegularTask()`: Dequeues a task from the front.
    - `showAllRegular()`: Traverses the list to display all pending tasks.

---

## 💻 How to Run

1.  **Prerequisites**: Ensure you have [JDK](https://www.oracle.com/java/technologies/downloads/) installed.
2.  **Compile**: 
    ```bash
    javac Main.java
    ```
3.  **Execute**:
    ```bash
    java Main
    ```

---

## 📋 Menu Options

| Choice | Action | Data Logic |
| :--- | :--- | :--- |
| **[1]** | Add Urgent Task | Push to Array Stack |
| **[2]** | Handle Urgent Task | Pop from Array Stack |
| **[3]** | Peek Urgent | View top of Stack |
| **[4]** | Add Regular Task | Add to end of Linked List |
| **[5]** | Process Regular Task | Remove from front of Linked List |
| **[6]** | Peek Regular | View front of Queue |
| **[7]** | Show All Urgent | Iterate Stack (Top to Bottom) |
| **[8]** | Show All Regular | Traverse Linked List |
| **[9]** | Exit | Terminate Application |

---

## 📝 Code Logic Example

### Urgent Task (Stack) Logic
When you add tasks "A", "B", and then "C", the "Handle" action will return **"C"** first because it was the last one added.

### Regular Task (Queue) Logic
When you add tasks "A", "B", and then "C", the "Process" action will return **"A"** first because it was the first one added.
