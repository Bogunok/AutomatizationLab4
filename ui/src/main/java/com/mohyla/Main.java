package com.mohyla;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = null;
        while (true) {
            System.out.println("Enter the type of athlete (sambist/judoka):");
            type = scanner.nextLine().trim().toLowerCase();
            if (type.equals("sambist") || type.equals("judoka")) break;
            else System.out.println("Invalid athlete type. Please enter 'sambist' or 'judoka'.");
        }

        String name = null;
        while (true) {
            System.out.println("Enter the name of the athlete:");
            name = scanner.nextLine().trim();
            if (!name.isEmpty() && name.matches("[a-zA-Z]+")) break;
            else System.out.println("Invalid name. Please enter a non-empty name without numbers.");
        }

        int age = 0;
        while (true) {
            System.out.println("Enter the age of the athlete:");
            String ageInput = scanner.nextLine();
            if (ageInput.matches("\\d+")) {
                try {
                    age = Integer.parseInt(ageInput);
                    if (age <= 0) System.out.println("Invalid age. Please enter a positive integer.");
                    else break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age. Please enter a valid integer.");
                }
            } else {
                System.out.println("Invalid age. Please enter a positive integer without letters.");
            }
        }

        if (type.equals("sambist")) {
            Sambist sambist = new Sambist(name, age);
            AnnotationValidator.validate(sambist);
            saveAthleteToFile(sambist.getName(), sambist.getAge(), sambist.getSport());
        } else if (type.equals("judoka")) {
            Judoka judoka = new Judoka(name, age);
            AnnotationValidator.validate(judoka);
            saveAthleteToFile(judoka.getName(), judoka.getAge(), judoka.getSport());
        }
        System.out.println("Athlete information saved.");
    }

    private static void saveAthleteToFile(String name, int age, String sport) {
        try (FileWriter writer = new FileWriter("athlete.txt", true)) {
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Sport: " + sport + "\n");
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}