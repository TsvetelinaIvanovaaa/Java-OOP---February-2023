package WorkingWithAbstraction;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTopPart(n);

        printMiddlePart(n);

        printBottomPart(n);
    }

    private static void printBottomPart(int n) {
        for (int row = n - 1; row >= 1 ; row--) {
            printRow(n, row);
        }
    }

    private static void printMiddlePart(int n) {
        for (int star = 1; star <= n; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTopPart(int n) {
        for (int row = 1; row <= n -1 ; row++) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {
        //всеки ред -> брой интервали = n - номера на реда; брой звездички = номера на реда
        // n = 3
        //1-ви ред -> 2 интервала + 1 звездичка

        //2-ри ред -> 1 интервал + 2 звездички
        for (int space = 1; space <= n - row ; space++) {
            System.out.print(" ");
        }
        printMiddlePart(row);
    }
}
