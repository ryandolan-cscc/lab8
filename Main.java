package edu.cscc;

import java.util.Scanner;

// BMI Calculator
// By Ryan Dolan - CC0

public class Main {

    private static Scanner input = new Scanner(System.in);
    public static String bmiClassification;
    public static double calcBMI;

    public static double getNumber(String str) {
        while (true) {
            try {
                System.out.println(str);
                double dub = Double.parseDouble(input.nextLine());

                if (dub < 0) {
                    throw new NumberFormatException();
                }

                return dub;
            } catch(NumberFormatException e) {
                System.out.println("Invalid input. Please only type positive, numeric characters.");
            }
        }
    }

    public static double convertToKilograms(double lbs) {
        if (lbs <= 0) {
            throw new NumberFormatException();
        }
        return lbs / 2.2046;
    }

    public static double convertToMeters(double in) {
        if (in <= 0) {
            throw new NumberFormatException();
        }
        return in / 39.37;
    }

    public static void main(String[] args) {
        System.out.println("BMI Calculator");
        double weight = convertToKilograms(getNumber("Enter weight (lbs): "));
        double height = convertToMeters(getNumber("Enter height (inches): "));

        calcBMI = weight / Math.pow(height, 2);

        if (calcBMI > 30) {
            bmiClassification = "Obese";
        } else if (calcBMI > 25) {
            bmiClassification = "Overweight";
        } else if (calcBMI > 18.5) {
            bmiClassification = "Normal";
        } else {
            bmiClassification = "Underweight";
        }

        System.out.println("Your BMI is " + calcBMI);
        System.out.println("Your BMI classification is " + bmiClassification);
    }
}
