import java.util.Scanner;
import java.util.Stack;

public class DT_StackOps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expressions to check: ");
        String entry = sc.nextLine();

        // measure time & memory BEFORE
        long startTime = System.nanoTime();
        long beforeUsedMem = usedMemory();

        boolean ok = BalanceCheck(entry);

        // measure time & memory AFTER
        long endTime = System.nanoTime();
        long afterUsedMem = usedMemory();

        // results
        System.out.println(ok ? "Perfect!" : "Check for Missing Symbol/s !");
        System.out.printf("Execution time: %.3f ms%n", (endTime - startTime) / 1_000_000.0);
        System.out.printf("Memory used: %d bytes%n", (afterUsedMem - beforeUsedMem));

        sc.close();
    }

    // subfunction to check if Balanced
    public static boolean BalanceCheck(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (!matches(open, ch)) {
                    return false;
                }
            }
            // all other characters ignored
        }

        return stack.isEmpty();
    }

        // Subfunction to check if it matches
        private static boolean matches ( char open, char close){
            return (open == '(' && close == ')') ||
                    (open == '{' && close == '}') ||
                    (open == '[' && close == ']');
        }

        // Subfunction to check heap memory
        private static long usedMemory() {
            Runtime rt = Runtime.getRuntime();
            return rt.totalMemory() - rt.freeMemory();
        }
    }

