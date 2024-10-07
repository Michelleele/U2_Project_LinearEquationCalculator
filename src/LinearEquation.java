public class LinearEquation {
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

    public LinearEquation(String userInputOne, String userInputTwo) {
        xOne = Integer.parseInt(userInputOne.substring(1, userInputOne.indexOf(",")));
        yOne = Integer.parseInt(userInputOne.substring(userInputOne.indexOf(",") + 1, userInputOne.length() - 1));
        xTwo = Integer.parseInt(userInputTwo.substring(1, userInputTwo.indexOf(",")));
        yTwo = Integer.parseInt(userInputTwo.substring(userInputTwo.indexOf(",") + 1, userInputTwo.length() - 1));
        printedYInt = "";
        printedFractionSlope = "";
        calculations();
    }

    public void calculations() {
        findSlopeDenominator();
        findSlopeNumerator();
        setCalcSlope();
        findYInt();
        setPrintSlope();
        setPrintYInt();
    }

    public void findSlopeNumerator() {
        slopeNumerator = yTwo - yOne;
    }

    public void findSlopeDenominator() {
        slopeDenominator = xTwo - xOne;
    }

    public void setCalcSlope() {
        calculationSlope = (double) slopeNumerator / slopeDenominator;
    }

    public boolean isSlopeOne() {
        return slopeNumerator == slopeDenominator;
    }

    public boolean isYIntZero() {
        return yInt == 0;
    }

    public boolean isSlopeWholeNumber() {
        return (slopeNumerator % slopeDenominator == 0);
    }

    public boolean isNeg(double x) {
        return (x < 0);
    }

    public void setPrintSlope() {
        if (isNeg(calculationSlope)) {
            printedFractionSlope = printedFractionSlope + " -";
        }
        else {
            printedFractionSlope = printedFractionSlope + " ";
        }
        if (isSlopeWholeNumber()) {
            if (!isSlopeOne()) {
                printedFractionSlope = printedFractionSlope + (int) calculationSlope;
            }
        }
        else if (isNeg(slopeDenominator) || (isNeg(slopeNumerator) )) {
            if (isNeg(slopeDenominator)) {
                slopeDenominator = slopeDenominator * -1;
            }
            if (isNeg(slopeNumerator)) {
                slopeNumerator = slopeNumerator * -1;
            }
            printedFractionSlope = printedFractionSlope + slopeNumerator + "/" + slopeDenominator;
        }
    }

    public void findYInt() {
        yInt = yOne - (calculationSlope * xOne);
    }

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

    public String findLinearEquation() {
        return ("y =" + printedFractionSlope + "x" + printedYInt);
    }

    public double findDistance() {
        int a = xTwo - xOne;
        int b = yTwo - yOne;
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public String toString() {
        return (" Slope of line:" + printedFractionSlope + "\n Y-intercept:" + printedYInt + "\n Slope intercept form: " + findLinearEquation() + "\n Distance between points: " + findDistance());
    }

    public double solveForY(double userX) {
        return ((calculationSlope * userX) + yInt);
    }

    public String printSolvedCoordinates(double userX) {
        return ("Solved coordinate point is: (" + userX + ", " + solveForY(userX) + ")");
    }

}
