public class Circular {
    public int max;
    public int[] queue;
    public int first, last;

    // Create and define size
    public Circular(int max) {
        this.max = max;
        this.queue = new int[max];
        this.first = -1;
        this.last = -1;
    }
    public boolean isFull() {
        return (last + 1) % max == first;
    }
    public boolean isEmpty() {
        return first == -1;
    }

    // Enqueue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        if (first == -1) {
            first = 0;
        }
        last = (last + 1) % max;
        queue[last] = data;
    }

    // Dequeue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int data = queue[first];
        if (first == last) { // Only one element
            first = -1;
            last = -1;
        } else {
            first = (first + 1) % max;
        }
        return data;
    }

    // Display
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("[Queue] =  ");
        int i = first;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == last) break;
            i = (i + 1) % max;
        }
        System.out.println();

    }

   // Test
    public static void main(String[] args) {
        //memory and time record
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long startTime = System.nanoTime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        Circular cq = new Circular(8);

        // Fill the queue
        cq.enqueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(40);
        cq.enqueue(80);
        cq.display();

        // Dequeue
        System.out.println("[Dequeued] = " + cq.dequeue());
        cq.display();

        cq.enqueue(5);
        cq.display();

        // memory and time usage capture

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;
        long memoryUsed = memoryAfter - memoryBefore;

        System.out.println("\n--- Performance Report ---");
        System.out.println("Execution Time (ms): " + executionTime / 1_000_000);
        System.out.println("Memory Used (bytes): " + memoryUsed);
    }
}
