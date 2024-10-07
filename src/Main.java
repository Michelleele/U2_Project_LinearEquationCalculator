import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner kyx = new Scanner(System.in);

        System.out.print("Enter your first Coordinate Point: ");
        String coordinateOne = kyx.nextLine();
        System.out.print("Enter your second Coordinate Point: ");
        String coordinateTwo = kyx.nextLine();

        LinearEquation linearOne = new LinearEquation(coordinateOne, coordinateTwo);

        System.out.print("---------------------------------------------------------\n" + linearOne + "\n---------------------------------------------------------\nEnter a third x-value: ");
        double x = kyx.nextDouble();
        System.out.println("---------------------------------------------------------\nSolved Coordinate point is: "+ linearOne.printSolvedCoordinates(x));
        }
    }
