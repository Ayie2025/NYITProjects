public class TwoD_Array {
    public static void main(String[] args) {
        // Create a 3x3 array
        int[][] array2D = new int[3][3];

        // Fill with values 1–9
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array2D[i][j] = i * 3 + j + 1;  // formula
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array2D[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
