import java.util.Scanner;
import java.util.Stack;

public class Test_Stack {
    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String input = x.nextLine();

        Stack<Character> NameCH = new Stack<>(); //Initializing

        // Push characters into the stack
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            NameCH.push(character);
        }

        System.out.println("Elements pushed in the stack" + NameCH); // Validating the elements inside the stack

        // Pop elements from the stack
        System.out.print("Reversed Output: ");
        while (!NameCH.isEmpty()) {
            System.out.print(NameCH.pop());
        }
    }
}

