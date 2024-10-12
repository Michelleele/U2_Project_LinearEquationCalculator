import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner kyx = new Scanner(System.in);

        //Asking the user for inputs of two coordinate points
        System.out.print("Enter your first Coordinate Point: ");
        String coordinateOne = kyx.nextLine();
        System.out.print("Enter your second Coordinate Point: ");
        String coordinateTwo = kyx.nextLine();

        //creates a new object using user inputs
        LinearEquation linearOne = new LinearEquation(coordinateOne, coordinateTwo);
        //prints out info on the two coordinate points
        System.out.print("---------------------------------------------------------\n" + linearOne + "\n---------------------------------------------------------\nEnter a third x-value: ");

        //asks the user for an x a=value input
        double x = kyx.nextDouble();

        //prints out the resulting coordinate point
        System.out.println("---------------------------------------------------------\n"+ linearOne.printSolvedCoordinates(x));
        }
    }
