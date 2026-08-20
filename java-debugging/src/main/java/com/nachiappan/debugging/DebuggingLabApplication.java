package com.nachiappan.debugging;

import java.util.Scanner;

public class DebuggingLabApplication {
    private final DebuggingExercises exercises = new DebuggingExercises();

    public static void main(String[] args) {
        new DebuggingLabApplication().run();
    }

    private void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            printWelcome();
            boolean running = true;
            while (running) {
                printMenu();
                String choice = scanner.nextLine().trim();
                System.out.println();
                switch (choice) {
                    case "1" -> exercises.stepThroughCalculation();
                    case "2" -> exercises.inspectObjectState();
                    case "3" -> exercises.investigateException();
                    case "4" -> exercises.followThreadExecution();
                    case "5" -> exercises.followReflectionCall();
                    case "0" -> running = false;
                    default -> System.out.println("Unknown choice. Select 0-5.");
                }
                System.out.println();
            }
        }
        System.out.println("Debugging lab complete.");
    }

    private void printWelcome() {
        System.out.println("Java Debugging Lab");
        System.out.println("Choose an exercise, launch in debug mode, and inspect the marked methods.");
    }

    private void printMenu() {
        System.out.println("1. Step through a calculation");
        System.out.println("2. Inspect object and collection state");
        System.out.println("3. Investigate an exception");
        System.out.println("4. Debug a worker thread");
        System.out.println("5. Follow a reflection call");
        System.out.println("0. Exit");
        System.out.print("Exercise: ");
    }
}
