public class LinearEquation {

    //attributes
    private int xOne;
    private int yOne;
    private int xTwo;
    private int yTwo;
    private double calculationSlope;
    private double yInt;
    private int slopeNumerator;
    private int slopeDenominator;
    private String printedFractionSlope;
    private String printedYInt;

    // constructor method that creates an object and initiate all the attributes located in this class and performs all the necessary calculations
    public LinearEquation(String userInputOne, String userInputTwo) {
        xOne = Integer.parseInt(userInputOne.substring(1, userInputOne.indexOf(",")));
        yOne = Integer.parseInt(userInputOne.substring(userInputOne.indexOf(",") + 1, userInputOne.length() - 1));
        xTwo = Integer.parseInt(userInputTwo.substring(1, userInputTwo.indexOf(",")));
        yTwo = Integer.parseInt(userInputTwo.substring(userInputTwo.indexOf(",") + 1, userInputTwo.length() - 1));
        printedYInt = "";
        printedFractionSlope = "";
        calculations();
    }

    // method to organize all the calculations that needs to be performed in their specific order
    public void calculations() {
        findSlopeDenominator();
        findSlopeNumerator();
        setCalcSlope();
        findYInt();
        setFractionSlope();
        setPrintYInt();
    }

    // finds the numerator of the slope of the line
    public void findSlopeNumerator() {
        slopeNumerator = yTwo - yOne;
    }

    //finds the denominator of the slope of the line
    public void findSlopeDenominator() {
        slopeDenominator = xTwo - xOne;
    }

    //finds the actual value of the slope of the line
    public void setCalcSlope() {
        calculationSlope = (double) slopeNumerator / slopeDenominator;
    }

    //checks if the slope is one
    public boolean isSlopeOne() {
        return slopeNumerator == slopeDenominator;
    }

    //checks if the slope is zero
    public boolean isYIntZero() {
        return yInt == 0;
    }

    //checks if the slope is a whole number
    public boolean isSlopeWholeNumber() {
        return (slopeNumerator % slopeDenominator == 0);
    }

    //checks if the parameter stored a negative value
    public boolean isNeg(double x) {
        return (x < 0);
    }

    //finds the y intercept of the line
    public void findYInt() {
        yInt = yOne - (calculationSlope * xOne);
    }

    //sets y intercept into a String and adding - in front if necessary
    public void setPrintYInt() {
        if (!isYIntZero()) {
            if (isNeg(yInt)) {
                double temp = yInt * -1;
                printedYInt = printedYInt + " - " + temp;
            }
            else {
                printedYInt = printedYInt + " + " + yInt;
            }
        }
    }

    // evaluating whether x needs a negative sign in front of its String and returns one if needed
    public String setPosOrNeg(double x) {
        if (isNeg(x)) {
            return " - ";
        }
        return " ";
    }

    //sets the numerator and denominator of the slope to positive values if both the numerator and denominator is a negative value
    public void setSlopeNumeratorDenominatorStandard() {
        if (isNeg(slopeNumerator) && isNeg(slopeDenominator)) {
            slopeNumerator *= -1;
            slopeDenominator *= -1;
        }
    }

    // sets the slope of the line as a String stored in variable printedFractionSlope
    public void setFractionSlope() {
        setSlopeNumeratorDenominatorStandard();
        printedFractionSlope = setPosOrNeg(calculationSlope) + slopeNumerator + "/" + slopeDenominator;
    }

    // sets up the linear equation of the line as a String
    public String findLinearEquation() {
        if (isSlopeWholeNumber()) {
            if (isSlopeOne()) {
                return  ("y =" + setPosOrNeg(calculationSlope) + "x" + printedYInt);
            }
            return  ("y =" + setPosOrNeg(calculationSlope) + (int) calculationSlope + "x" + printedYInt);
        }
        else {
            return  ("y =" + printedFractionSlope + "x" + printedYInt);
        }
    }

    //finds the distance between the two coordinates
    public double findDistance() {
        int a = xTwo - xOne;
        int b = yTwo - yOne;
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    //placed and organized all information regarding the two coordinates into a String
    public String toString() {
        return (" Slope of line:" + printedFractionSlope + "\n Y-intercept:" + printedYInt + "\n Slope intercept form: " + findLinearEquation() + "\n Distance between points: " + findDistance());
    }

    //solves for the value of y using the linear equation and the x value given by user
    public double solveForY(double userX) {
        return ((calculationSlope * userX) + yInt);
    }

    //placed and organized the resulting coordinate point from method solveForY() into a String
    public String printSolvedCoordinates(double userX) {
        return ("Solved coordinate point is: (" + userX + ", " + solveForY(userX) + ")");
    }

}
