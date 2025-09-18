import java.util.Random;

public class HW_Array {
    public static void main(String[] args) {
        int[] arr = new int[10]; // Declare an array of 10 integers
        Random RandV = new Random();

        int counter = 0;
        while (counter < arr.length) {
            arr[counter] = RandV.nextInt(1000) + 1;  // Initializing with random values to 1000
            System.out.println(arr[counter]);  // Print all elements using a loop
            counter++;
        }

        // Finding Min & Max Values
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Printing Min & Max Values
        System.out.println("Max Array value: " + max);
        System.out.println("Min Array value: " + min);
    }
}
