/*
 * Hafsa Javed
 * Student ID: 203037585
 * 2nd Feb 2024
 * This is a java program that compares the areas of two shapes
 */

package Assignment2;

import java.util.Scanner;

public class Areas {

    public static void main(String[] args) {
        int shapeChoice1 = getShapeChoice();
        double[] dimensions1 = getShapeDimensions(shapeChoice1);
        double area1 = calculateShapeArea(shapeChoice1, dimensions1);

        int shapeChoice2 = getShapeChoice();
        double[] dimensions2 = getShapeDimensions(shapeChoice2);
        double area2 = calculateShapeArea(shapeChoice2, dimensions2);

        displaySummary(area1, area2);
    }

    
    public static int getShapeChoice() {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Select a shape:");
        System.out.println("1. Rectangle");
        System.out.println("2. Triangle");
        System.out.println("3. Circle");
        System.out.print("Enter your choice (1, 2, or 3): ");

        int choice = 0;

        
        while (choice < 1 || choice > 3) {
            String input = scanner.nextLine();
            if (input.matches("[1-3]")) {
                choice = Integer.parseInt(input);
            } else {
                System.out.print("Invalid input. Enter a valid choice (1, 2, or 3): ");
            }
        }

        return choice;
    }

    
    public static double[] getShapeDimensions(int shapeChoice) {
        Scanner scanner = new Scanner(System.in);
        double[] dimensions = new double[2]; 

        if (shapeChoice == 1) { 
            dimensions[0] = getUserInput("Enter rectangle width: ");
            dimensions[1] = getUserInput("Enter rectangle height: ");
        } else if (shapeChoice == 2) { 
            dimensions[0] = getUserInput("Enter triangle base: ");
            dimensions[1] = getUserInput("Enter triangle height: ");
        } else if (shapeChoice == 3) { 
            dimensions[0] = getUserInput("Enter circle radius: ");
        }

        return dimensions;
    }

    
    private static double calculateShapeArea(int shapeChoice, double[] dimensions) {
        if (shapeChoice == 1) { 
            return dimensions[0] * dimensions[1];
        } else if (shapeChoice == 2) { 
            return 0.5 * dimensions[0] * dimensions[1];
        } else if (shapeChoice == 3) { 
            return Math.PI * dimensions[0] * dimensions[0];
        } else {
            return 0.0; 
        }
    }

    
    private static double getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        double input = 0;

        while (true) {
            System.out.print(message);
            String inputStr = scanner.nextLine();

            if (inputStr.matches("\\d+(\\.\\d+)?")) {
                input = Double.parseDouble(inputStr);
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid numeric value.");
            }
        }

        return input;
    }

    
    private static void displaySummary(double area1, double area2) {
        double ratio = area1 / area2;

        System.out.println("First Shape Area: " + area1);
        System.out.println("Second Shape Area: " + area2);
        System.out.println("The area of the first shape seems " + String.format("%.2f", ratio) + " times bigger than the area of the second shape.");
    }
}

