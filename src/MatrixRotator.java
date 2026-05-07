public class MatrixRotator {public static void main(String[] args) {

    // 3x3 Test Matrix
    int[][] input = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };

    System.out.println("=== SMART MATRIX ROTATOR TESTS ===\n");
    System.out.println("Original Matrix:");
    printMatrix(input);

    System.out.println("--- Rotating 90 Degrees Right ---");
    int[][] res90 = rotate(input, 90);
    printMatrix(res90);

    System.out.println("--- Rotating 180 Degrees Right ---");
    int[][] res180 = rotate(input, 180);
    printMatrix(res180);

    System.out.println("--- Rotating 270 Degrees Right ---");
    int[][] res270 = rotate(input, 270);
    printMatrix(res270);

    System.out.println("--- Rotating 360 Degrees Right ---");
    int[][] res360 = rotate(input, 360);
    printMatrix(res360);

    System.out.println("--- Rotating 450 Degrees Right ---");
    int[][] res450 = rotate(input, 450);
    printMatrix(res450);
}

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("]");
        }
    }

    public static int[][] rotate(int matrix[][], int degrees) {
        degrees += 45;
        degrees = ((degrees % 360) + 360) % 360;
        degrees = ((degrees / 90) * 90) % 360;
        int rotations = degrees / 90;

        int temp[][] = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        if (rotations == 0) {
            return temp;
        }



        for (int i = 0; i < rotations; i++) {
            int[][] matrixTemp = new int[temp.length][temp[0].length];

            for (int row = 0; row < temp.length; row++) {
                for (int column = 0; column < temp[row].length; column++)
                    matrixTemp[column][matrixTemp[row].length - 1 - row] = temp[row][column];
            }
            temp = matrixTemp;
        }
        return temp;
    }
}