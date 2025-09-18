import java.util.Scanner;

public class InputScreen {
    public static void main(String[] args) {
        //Get userTo calculate the square root
        Scanner x = new Scanner(System.in);
        System.out.print("Enter the number to get the square root: ");
        int num = x.nextInt();
        double squareRoot = Math.sqrt(num);
        System.out.println(squareRoot);
        x.close();
    }
}
