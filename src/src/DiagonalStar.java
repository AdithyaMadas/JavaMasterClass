public class DiagonalStar {
    public static void printSquareStar(int a) {
        if (a < 5) {
            System.out.println("Invalid Value");
            return;
        }
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                if (i == 1 || i == a) {
                    System.out.printf("*");
                    continue;
                }
                if (j == 1 || j == a) {
                    System.out.printf("*");
                } else if (j == i || j == a - i+1) {
                    System.out.printf("*");
                } else {
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printSquareStar(8);
    }
}
